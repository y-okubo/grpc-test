package main

import (
	"log"
	"net"
	"sync"

	"golang.org/x/net/context"

	"google.golang.org/grpc"

	pb "github.com/y-okubo/grpc-test/go/proto"
)

type awesomeService struct {
	customers []*pb.Person
	m         sync.Mutex
}

func (cs *awesomeService) ListPerson(p *pb.RequestType, stream pb.AwesomeService_ListPersonServer) error {
	cs.m.Lock()
	defer cs.m.Unlock()
	for _, p := range cs.customers {
		if err := stream.Send(p); err != nil {
			return err
		}
	}
	return nil
}

func (cs *awesomeService) AddPerson(c context.Context, p *pb.Person) (*pb.ResponseType, error) {
	cs.m.Lock()
	defer cs.m.Unlock()
	cs.customers = append(cs.customers, p)
	return new(pb.ResponseType), nil
}

func main() {
	lis, err := net.Listen("tcp", "127.0.0.1:11111")
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}
	server := grpc.NewServer()

	pb.RegisterAwesomeServiceServer(server, new(awesomeService))
	log.Println("Listing...")
	server.Serve(lis)
}
