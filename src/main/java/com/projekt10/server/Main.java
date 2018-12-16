package com.projekt10.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class Main {
	public static int key = 0;
	public static void main(String[] args) {
		try{
			BufferedReader reader = new BufferedReader(new FileReader("key.txt"));
			try {
				key = Integer.parseInt(reader.readLine());
			}catch (IOException e){
				System.out.println("Can not open key.txt, setting to 4 by default");
				key = 4;
			}
		}catch(FileNotFoundException e){
			System.out.println("Not found key.txt, setting to 4 by default");
			key = 4;
		}
		SpringApplication.run(Main.class, args);
	}
}

