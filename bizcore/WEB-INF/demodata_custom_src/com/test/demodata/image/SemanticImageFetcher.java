package com.test.demodata.image;
import java.util.*;
import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class SemanticImageFetcher {
	public static List<Path> allImagesFiles(Path rootPath) throws IOException{
		
		try (Stream<Path> paths = Files.walk(rootPath, 3)) {
            return paths.filter(p->p.toString().endsWith(".jpg")
            		||p.toString().endsWith(".png")
            		||p.toString().endsWith(".gif")
            		)
            		.collect(Collectors.toList());
        }
		
		
		
	}
	public static Path candidatePath(Path rootPath, String key) throws IOException{
		
		
		
		try (Stream<Path> paths = Files.walk(rootPath, 3)) {
            Optional<Path> mayBePath = paths.filter(Files::isDirectory)
            	.filter(p->key.equals(p.getFileName().toString())).findFirst();
            
            if(mayBePath.isPresent()) {
            	return mayBePath.get();
            }
            return rootPath;
            
        }
		
		
		
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		String root="/Users/Philip/githome/xiao-mai-pu-catalog/pic/things";
		
		Path rootPath = Paths.get(root);
		Path candidatePath = candidatePath(rootPath,"cookie");
		List<Path> list = allImagesFiles(candidatePath);
		list.forEach(path->{
			System.out.println(path);
		});
		
	}
	
	

}
