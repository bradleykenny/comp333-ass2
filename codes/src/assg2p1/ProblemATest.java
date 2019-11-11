package assg2p1;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class ProblemATest {

	ProblemA p;
	@Before public void initialize() {
	}	
	
	@Test(timeout=500)
	public void test01() {

		String data = "src/data/a2p1_problemA_input_01.csv";
		p = new ProblemA(data);
		HashMap<String,HashMap<String,Integer>> actual = p.findNumberOfRoutes();
		
		String[] s = {"Hornsby","Lidcombe","Redfern","Strathfield","Sydenham"};

		Integer[][] expected = {{0,0,1,0,0},
								{1,0,3,1,1},
								{0,0,0,0,0},
								{1,0,3,0,1},
								{0,0,1,0,0}};
		
		for(int i = 0; i < s.length; i++) {
			for (int j = 0; j < s.length; j++) {
				assertEquals(expected[i][j],actual.get(s[i]).get(s[j]));
			}
		}
	}
	
	@Test(timeout=500)
	public void test02() {

		String data = "src/data/a2p1_problemA_input_02.csv";
		p = new ProblemA(data);
		HashMap<String,HashMap<String,Integer>> actual = p.findNumberOfRoutes();
		
		String[] s = {"Hornsby","Lidcombe","Redfern","Strathfield","Sydenham"};

		Integer[][] expected = {{-1,0,-1,-1,-1},
								{-1,0,-1,-1,-1},
								{-1,0,-1,-1,-1},
								{-1,0,-1,-1,-1},
								{0,0,0,0,0}};;
		
		for(int i = 0; i < s.length; i++) {
			for (int j = 0; j < s.length; j++) {
				assertEquals(expected[i][j],actual.get(s[i]).get(s[j]));
			}
		}
	}
	
	@Test(timeout=500)
	public void test03() {

		String data = "src/data/a2p1_problemA_input_03.csv";
		p = new ProblemA(data);
		HashMap<String,HashMap<String,Integer>> actual = p.findNumberOfRoutes();
		
		String[] s = {"Blacktown","Burwood","Central","Chatswood","Eastwood",
					  "Epping","Hornsby","Redfern","Strathfield"};

		Integer[][] expected = {{-1,-1,0,0,-1,-1,-1,0,0},
								{-1,-1,0,0,-1,-1,-1,0,0},
								{-1,-1,0,1,-1,-1,-1,1,1},
								{0,0,0,0,1,0,0,0,0},
								{0,0,0,0,0,0,0,0,0},
								{-1,-1,0,0,-1,-1,-1,0,0},
								{-1,-1,0,0,-1,-1,-1,0,0},
								{-1,-1,0,1,-1,-1,-1,0,0},
								{-1,-1,0,0,-1,-1,-1,0,0}};
		
		for(int i = 0; i < s.length; i++) {
			for (int j = 0; j < s.length; j++) {
				assertEquals(expected[i][j],actual.get(s[i]).get(s[j]));
			}
		}
	}
	
	@Test(timeout=500)
	public void test04() {

		String data = "src/data/a2p1_problemA_input_04.csv";
		p = new ProblemA(data);
		HashMap<String,HashMap<String,Integer>> actual = p.findNumberOfRoutes();
		
		String[] s = {"1","2","3","4","5","6","7","8"};
		Integer[][] expected = {
		  {0,0,0,1,1,1,1,3},
		  {0,0,0,1,1,1,1,3},
		  {0,0,0,1,1,1,1,3},
		  {0,0,0,0,1,1,1,3},
		  {0,0,0,0,0,0,0,1},
		  {0,0,0,0,0,0,0,1},
		  {0,0,0,0,0,0,0,1},
		  {0,0,0,0,0,0,0,0}};
		
		for(int i = 0; i < s.length; i++) {
			for (int j = 0; j < s.length; j++) {
				assertEquals(expected[i][j],actual.get(s[i]).get(s[j]));
			}
		}
	}
	
	@Test(timeout=500)
	public void test05() {

		String data = "src/data/a2p1_problemA_input_05.csv";
		p = new ProblemA(data);
		HashMap<String,HashMap<String,Integer>> actual = p.findNumberOfRoutes();
		
		String[] s = {"Bankstown","Blacktown","Central","Chatswood","Epping",
					  "Glenfield","Hornsby","Lidcombe","Liverpool","Macarthur",
					  "Parramatta","Penrith","Revesby","Richmond","Strathfield"
					  ,"Tallawong"};

		Integer[][] expected = {{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
								{2,0,6,2,1,1,1,1,1,1,1,0,1,0,1,0},
								{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
								{0,0,2,2,0,0,1,0,0,0,0,0,0,0,0,0},
								{0,0,1,0,0,0,0,0,0,1,0,0,1,0,0,0},
								{0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
								{1,0,4,2,1,0,1,0,0,0,0,0,0,0,1,0},
								{1,0,2,0,0,1,0,0,0,1,0,0,1,0,0,0},
								{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
								{1,0,4,2,1,0,1,1,0,0,0,0,0,0,1,0},
								{2,1,6,2,1,1,1,1,1,1,1,0,1,0,1,0},
								{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
								{2,1,6,2,1,1,1,1,1,1,1,0,1,0,1,0},
								{0,0,3,2,1,0,1,0,0,0,0,0,0,0,0,0},
								{0,0,2,2,1,0,1,0,0,0,0,0,0,0,0,0}};
		
		for(int i = 0; i < s.length; i++) {
			for (int j = 0; j < s.length; j++) {
				assertEquals(expected[i][j],actual.get(s[i]).get(s[j]));
			}
		}
	}
	
	@Test(timeout=500)
	public void test06() {

		String data = "src/data/a2p1_problemA_input_06.csv";
		p = new ProblemA(data);
		HashMap<String,HashMap<String,Integer>> actual = p.findNumberOfRoutes();
		
		String[] s = {"1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

		Integer[][] expected = {
				{0,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
				{1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
		
		for(int i = 0; i < s.length; i++) {
			for (int j = 0; j < s.length; j++) {
				assertEquals(expected[i][j],actual.get(s[i]).get(s[j]));
			}
		}
	}
	
	
	@Test(timeout=500)
	public void test07() {

		String data = "src/data/a2p1_problemA_input_07.csv";
		p = new ProblemA(data);
		HashMap<String,HashMap<String,Integer>> actual = p.findNumberOfRoutes();
		
		String[] s = {"1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

		Integer[][] expected = {
			{0,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{13090,26180,33660,38201,42730,43518,43518,43518,43518,0,1,2,4,6,8,10,21,32,64,120,56,176,142,286,428,771,1114,1401,1688,1831,3662,3804,1870,3740,5610},
			{6079,12158,15633,17743,19847,20214,20214,20214,20214,0,0,1,2,3,4,5,10,15,30,56,26,82,66,133,199,358,517,650,783,849,1698,1764,868,1736,2604},
			{2058,4116,5292,6006,6718,6842,6842,6842,6842,0,0,0,1,1,1,1,3,5,10,19,9,28,22,45,67,121,175,220,265,287,574,596,294,588,882},
			{1191,2382,3063,3477,3889,3961,3961,3961,3961,0,0,0,0,1,1,1,2,3,6,11,5,16,13,26,39,70,101,127,153,166,332,345,170,340,510},
			{1190,2380,3060,3473,3885,3957,3957,3957,3957,0,0,0,0,0,1,1,2,3,6,11,5,16,13,26,39,70,101,127,153,166,332,345,170,340,510},
			{1184,2368,3045,3456,3866,3938,3938,3938,3938,0,0,0,0,0,0,1,2,3,6,11,5,16,13,26,39,70,101,127,153,166,332,345,169,338,507},
			{455,910,1170,1327,1484,1511,1511,1511,1511,0,0,0,0,0,0,0,1,1,2,4,2,6,5,10,15,27,39,49,59,64,128,133,65,130,195},
			{454,908,1167,1324,1481,1508,1508,1508,1508,0,0,0,0,0,0,0,0,1,2,4,2,6,5,10,15,27,39,49,59,64,128,133,65,130,195},
			{189,378,486,552,618,630,630,630,630,0,0,0,0,0,0,0,0,0,1,2,1,3,2,4,6,11,16,20,24,26,52,54,27,54,81},
			{85,170,219,249,279,285,285,285,285,0,0,0,0,0,0,0,0,0,0,1,0,1,1,2,3,5,7,9,11,12,24,25,12,24,36},
			{1,2,3,4,5,6,6,6,6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{96,192,246,278,310,314,314,314,314,0,0,0,0,0,0,0,0,0,0,0,0,1,1,2,3,6,9,11,13,14,28,29,14,28,42},
			{1,2,3,4,5,6,6,6,6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{40,80,102,115,128,129,129,129,129,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,2,3,4,5,6,12,13,6,12,18},
			{34,68,87,98,109,110,110,110,110,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,4,5,5,10,10,5,10,15},
			{8,16,21,24,27,28,28,28,28,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,2,2,1,2,3},
			{7,14,18,20,22,22,22,22,22,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,2,2,1,2,3},
			{6,12,15,17,19,19,19,19,19,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,2,2,1,2,3},
			{6,12,15,17,19,19,19,19,19,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,2,2,1,2,3},
			{6,12,15,17,19,19,19,19,19,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,2,1,2,3},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{3,6,8,9,10,10,10,10,10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
			{2,4,5,6,7,7,7,7,7,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,2,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
		
		for(int i = 0; i < s.length; i++) {
			for (int j = 0; j < s.length; j++) {
				assertEquals(expected[i][j],actual.get(s[i]).get(s[j]));
			}
		}
	}
	
	
}