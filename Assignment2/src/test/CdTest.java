package test;

import static org.junit.Assert.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import command.Cd;
import fileSystem.Directory;
import fileSystem.FileSystem;


public class CdTest {
  FileSystem fs;
  Directory root;
  Directory workingDir;
  Directory expected;
  Directory actual;
  Cd cd;
  ArrayList<Object> params;
  String input;
  
  @Before
  public void setUp() {
    params = new ArrayList<Object>();
    fs = FileSystem.getFileSystem();
    root = fs.getRootDirectory();
    workingDir = fs.getCurrentDirectory();
    cd = new Cd();
  }
  
  @After
  public void reset() throws NoSuchFieldException, SecurityException, 
    IllegalArgumentException, IllegalAccessException {
    
    Field field = (fs.getClass()).getDeclaredField("fs");
    field.setAccessible(true);
    field.set(null, null);
  }

  @Test
  public void testCdToCurrentRelative() {
    expected = workingDir;
    input = "cd .";
    params.add(input);
    cd.execute(params);
    
    assertEquals(expected, workingDir);
    }
  
  @Test
  public void testCdToAbsoluteChild() {
    Directory dir1 = new Directory("hello");
    workingDir.getListOfFileSystemNodes().put("hello", dir1);
    dir1.setParentDirectory(workingDir);
    expected = dir1;
    input = "cd /hello/";
    params.add(input);
    cd.execute(params);
    actual = fs.getCurrentDirectory();
  }
  
  @Test
  public void testCdToParent() {
    Directory dir1 = new Directory("child");
    workingDir.getListOfFileSystemNodes().put("child", dir1);
    dir1.setParentDirectory(workingDir);
    input = "cd /child/";
    params.add(input);
    cd.execute(params);
    params = new ArrayList<Object>();
    input = "cd ..";
    params.add(input);
    cd.execute(params);
    expected = fs.getRootDirectory();
    actual = fs.getCurrentDirectory();
    
    assertEquals(expected, actual);
  }
  

}
