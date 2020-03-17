package com.test.demodata.image;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;
import java.io.File;
import java.nio.file.Files;
public class SemanticImageFetcher {
	
	
	
	public static byte[] fileContentOf(String filePath) throws IOException {
		
		byte[] fileContent = Files.readAllBytes(Paths.get(filePath));
		return fileContent;
	}
	
	
	private  Map<String,String[]> storedCache;
	
	protected Map<String,String[]> getStoredCache() {
		
		if(storedCache!=null) {
			return storedCache;
		}
		
		storedCache = new HashMap<String,String[]>();
		return storedCache;
		
	}
	protected String [] modifyStoredCache(Path selectedPath, List<Path> commonFiles) {
		
		
		if(commonFiles.isEmpty()) {
			String message = "modifyStoredCache(selectedPath, commonFiles): commonFiles is not expected to be empty"; 
			throw new IllegalArgumentException(message);
			//return new String[] {}; //no possibility for now.
		}
		
		
		Map<String,String[]> cache =  getStoredCache();
		String [] filePaths = commonFiles.stream()
				.map(path->path.toString())
				.collect(Collectors.toList()).toArray(new String[] {});
		cache.put(selectedPath.getFileName().toString(), filePaths);
		
		return filePaths;
		
		
	}
	protected String [] initWithKey(String key) throws IOException {
		String root="/Users/Philip/githome/xiao-mai-pu-catalog/pic/things";
		
		Path rootPath = Paths.get(root);
		Path candidatePath = candidatePath(rootPath,key);
		
		List<Path> pathList = allImagesFiles(candidatePath);
		
		return modifyStoredCache(candidatePath,pathList);
		
		
		
	}
	public String [] getFileCandidates(String key) throws IOException {
		Map<String,String[]> cache =  getStoredCache();
		
		String[] fileList = cache.get(key);
		
		if(fileList==null) {
			return initWithKey(key);
		}
		
		if(fileList.length==0) {
			return new String[] {};
		}
		return fileList;
		
		
	}
	
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
	
	
	public static String keyOf(String note) {
		
		StringBuilder ret = new StringBuilder();
		char [] chs=note.toCharArray();
		for(int i=0;i<chs.length;i++) {
			char ch = chs[i];
			if(Character.isDigit(ch)) {
				continue;
			}
			ret.append(chs[i]);
		}
		
		return ret.toString();
		
		
	}
	public static int indexOf(String note) {
		
		StringBuilder ret = new StringBuilder();
		char [] chs=note.toCharArray();
		for(int i=0;i<chs.length;i++) {
			char ch = chs[i];
			if(!Character.isDigit(ch)) {
				continue;
			}
			ret.append(chs[i]);
		}
		if(ret.length()==0) {
			return 1;
		}
		
		return Integer.parseInt(ret.toString());
		
		
	}
	public static void main(String[] args) throws IOException {
		String root="/Users/Philip/githome/xiao-mai-pu-catalog/pic/things";
		
		Path rootPath = Paths.get(root);
		Path candidatePath = candidatePath(rootPath,"cookie");
		List<Path> list = allImagesFiles(candidatePath);
		list.forEach(path->{
			System.out.print(candidatePath.getFileName().toString()); 
			System.out.println(path);
		});
		
	}
	
	

}
