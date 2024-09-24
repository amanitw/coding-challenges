package com.example.stage;

import com.example.stage.blog.dll.DoublyLinkedList;
import com.example.stage.blog.dll.Node;
import com.example.stage.loadbalancer.TCPServer;
import com.example.stage.post.cache.Cache;
import com.example.stage.post.cache.FileCache;
import com.example.stage.post.client.PostAPIClient;
import com.example.stage.post.model.Post;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException {
		//SpringApplication.run(Application.class, args);
//		PostAPIClient client = new PostAPIClient();
//		Cache fileCache = new FileCache();
//		List<Post> posts = client.fetchPost();
//		System.out.println("Hello");
//		String filePath = fileCache.write(posts);
//		List<Post> allPost = fileCache.read(filePath);
//		List<Post> user10 = allPost.stream().filter(post -> post.getUserId().equals("10")).collect(Collectors.toList());
//		System.out.println(user10);

//		TCPServer tcpServer = new TCPServer();
//		tcpServer.start(args);


//		TCPServer tcpServer = new TCPServer();
//		tcpServer.startup();

		DoublyLinkedList dll = new DoublyLinkedList();
		dll.add(1);
		dll.add(2);
		dll.add(3);
		dll.add(4);
		dll.print();
		System.out.println("---");
		dll.delete(1);
		dll.print();
		System.out.println("---");
		dll.delete(4);
		dll.print();
		System.out.println("---");
		dll.add(1);
		dll.print();
		System.out.println("---");
		dll.delete(2);
		dll.delete(1);
		dll.delete(3);
		dll.print();
		System.out.println("---");
		dll.add(2);
		dll.print();
		System.out.println("---");

	}

}
