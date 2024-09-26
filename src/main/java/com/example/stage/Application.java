package com.example.stage;

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
		Board board = new Board(100,new Dice(6));
		board.setBoardEntity(2,new Ladder(2,50));
		board.setBoardEntity(4,new Ladder(4,76));
		board.setBoardEntity(8,new Ladder(8,25));
		board.setBoardEntity(16,new Snake(16,2));
		board.setBoardEntity(26,new Snake(26,20));
		board.setBoardEntity(53,new Snake(53,3));
		Player p1 = new Player("1","aman");
		Player p2 = new Player("2","raman");
		Game game = new Game(board, Arrays.asList(p1,p2));
		game.startGame();
	}

}
