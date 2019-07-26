package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import command.Cat;
import command.Cd;
import command.Command;
import command.Cp;
import command.Echo;
import command.Exit;
import command.Find;
import command.Get;
import command.History;
import command.Load;
import command.Ls;
import command.Man;
import command.Mkdir;
import command.Mv;
import command.Popd;
import command.Pushd;
import command.Pwd;
import command.Save;
import command.Tree;


public class TestCommandTest {
  Command var;
  String acutal;
  String expected;

  @Before
  public void setUp() {
    var = null;
    acutal = null;
    expected = null;
  }


  @Test
  public void testtoStringCat() {
    expected = "Cat";
    var = new Cat();
    acutal = var.toString();

    assertEquals(expected, acutal);
  }

  @Test
  public void testtoStringCd() {
    expected = "Cd";
    var = new Cd();
    acutal = var.toString();

    assertEquals(expected, acutal);
  }

  @Test
  public void testtoStringExit() {
    expected = "Exit";
    var = new Exit();
    acutal = var.toString();

    assertEquals(expected, acutal);
  }

  @Test
  public void testtoStringMkdir() {
    expected = "Mkdir";
    var = new Mkdir();
    acutal = var.toString();

    assertEquals(expected, acutal);
  }

  @Test
  public void testtoStringLs() {
    expected = "Ls";
    var = new Ls();
    acutal = var.toString();

    assertEquals(expected, acutal);
  }

  @Test
  public void testtoStringPwd() {
    expected = "Pwd";
    var = new Pwd();
    acutal = var.toString();

    assertEquals(expected, acutal);
  }

  @Test
  public void testtoStringMv() {
    expected = "Mv";
    var = new Mv();
    acutal = var.toString();

    assertEquals(expected, acutal);
  }

  @Test
  public void testtoStringCp() {
    expected = "Cp";
    var = new Cp();
    acutal = var.toString();

    assertEquals(expected, acutal);
  }

  @Test
  public void testtoStringGet() {
    expected = "Get";
    var = new Get();
    acutal = var.toString();

    assertEquals(expected, acutal);
  }

  @Test
  public void testtoStringEcho() {
    expected = "Echo";
    var = new Echo();
    acutal = var.toString();

    assertEquals(expected, acutal);
  }

  @Test
  public void testtoStringMan() {
    expected = "Man";
    var = new Man();
    acutal = var.toString();

    assertEquals(expected, acutal);
  }

  @Test
  public void testtoStringPushd() {
    expected = "Pushd";
    var = new Pushd();
    acutal = var.toString();

    assertEquals(expected, acutal);
  }

  @Test
  public void testtoStringPopd() {
    expected = "Popd";
    var = new Popd();
    acutal = var.toString();

    assertEquals(expected, acutal);
  }

  @Test
  public void testtoStringHistory() {
    expected = "History";
    var = new History();
    acutal = var.toString();

    assertEquals(expected, acutal);
  }

  @Test
  public void testtoStringSave() {
    expected = "Save";
    var = new Save();
    acutal = var.toString();

    assertEquals(expected, acutal);
  }

  @Test
  public void testtoStringLoad() {
    expected = "Load";
    var = new Load();
    acutal = var.toString();

    assertEquals(expected, acutal);
  }

   @Test
   public void testtoStringFind()
   {
     expected = "Find";
     var = new Find();
     acutal=var.toString();
    
     assertEquals(expected, acutal);
   }
  @Test
  public void testtoStringTree() {
    expected = "Tree";
    var = new Tree();
    acutal = var.toString();

    assertEquals(expected, acutal);
  }


}
