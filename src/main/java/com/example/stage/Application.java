package com.example.stage;

import com.example.stage.lld.lru.service.DLLBasedLRU;
import com.example.stage.lld.lru.service.LRU;
import com.example.stage.lld.snakeandladder.model.*;
import com.example.stage.lld.snakeandladder.service.Game;
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
import java.util.Arrays;
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
//		Board board = new Board(100,new Dice(6));
//		board.setBoardEntity(2,new Ladder(2,50));
//		board.setBoardEntity(4,new Ladder(4,76));
//		board.setBoardEntity(8,new Ladder(8,25));
//		board.setBoardEntity(16,new Snake(16,2));
//		board.setBoardEntity(26,new Snake(26,20));
//		board.setBoardEntity(53,new Snake(53,3));
//		Player p1 = new Player("1","aman");
//		Player p2 = new Player("2","raman");
//		Game game = new Game(board, Arrays.asList(p1,p2));
//		game.startGame();

		LRU<Integer,Integer> cache = new DLLBasedLRU<>(3);

		cache.put(1, 100); // Insert key 1 with value 100
		cache.put(2, 200); // Insert key 2 with value 200
		cache.put(3, 300); // Insert key 3 with value 300
		System.out.println(cache.get(1));      // Access key 1, expected result: 100
		cache.put(4, 400); // Insert key 4, this should evict key 2 (least recently used)
		System.out.println(cache.get(2));      // Access key 2, expected result: -1 (key 2 was evicted)
		cache.put(5, 500); // Insert key 5, this should evict key 3 (least recently used)
		System.out.println(cache.get(3));      // Access key 3, expected result: -1 (key 3 was evicted)
		System.out.println(cache.get(4));      // Access key 4, expected result: 400
		System.out.println(cache.get(5));		// Access key 5, expected result: 500
		cache.put(1,1000);
		cache.put(6,600);
		System.out.println(cache.get(4));
		System.out.println(cache.get(1));
		System.out.println(cache.get(5));
	}

}
