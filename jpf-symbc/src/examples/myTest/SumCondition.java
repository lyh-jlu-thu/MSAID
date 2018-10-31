package myTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import gov.nasa.jpf.symbc.SymbolicInstructionFactory;
import gov.nasa.jpf.symbc.numeric.PathCondition;
import gov.nasa.jpf.symbc.numeric.SymbolicConstraintsGeneral;

public class SumCondition {
	public static Map<String, Object> solveWithValuation(PathCondition pa2) {
		SymbolicConstraintsGeneral solver = new SymbolicConstraintsGeneral();
		solver.cleanup();
		Map<String,Object> result1 = solver.liyahui_solveWithSolution(pa2);
		solver.cleanup();
		PathCondition.flagSolved = true;
		return result1;
	}
	
	public static void main(String[] a){
				SymbolicInstructionFactory.bvlength = 64;
	    
		SymbolicInstructionFactory.maxPcLength = 10;
		SymbolicInstructionFactory.maxPcMSec = -1;
		SymbolicInstructionFactory.dp = new String[]{"z3bitvector"};
//		List<PathCondition> list1 = new ArrayList<PathCondition>();
//		for(int i = 0;i<3;i++){
//			put(i,"/home/sdnracer/floodlight/serivale/"+"myTestlistnerliyahui1main",list1);
//		}
//		List<PathCondition> list2 = new ArrayList<PathCondition>();
//		for(int i = 0;i<2;i++){
//			put(i,"/home/sdnracer/floodlight/serivale/"+"myTestlistnerliyahui2main",list2);
//		}
		for(int i = 0;i<7;i++){
			for(int j = 0;j<9;j++){
//				PathCondition pa1 = getPA(i,"/home/sdnracer/floodlight/serivale/"+"myTestlistnerliyahui1main");
				PathCondition pa1 = getPA(i,"/home/sdnracer/floodlight/serivale/"+"netfloodlightcontrollerfirewallJPFFirewallTestmain");
//				PathCondition pa2 = getPA(j,"/home/sdnracer/floodlight/serivale/"+"myTestlistnerliyahui2main");
				PathCondition pa2 = getPA(j,"/home/sdnracer/floodlight/serivale/"+"netfloodlightcontrollersimpleroutingJPFLyhSimpleRoutingmain");
				pa1.appendPathcondition(pa2);
				Map<String,Object> aa = solveWithValuation(pa1);
				if(aa!=null){
				System.out.println(pa1);
				System.out.println(aa);}
			}
		}
//		for(PathCondition pa1 : list1){
//			for(PathCondition pa2 : list2){
//				PathCondition pa1copy = pa1.make_copy();
//				pa1copy.appendPathcondition(pa2);
//				System.out.println(pa1copy);
//			}
//		}
	}
	
	
	private  static void put(int i,String s, List<PathCondition> list1 ){

		File file = new File(s+i);
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			try {
				PathCondition obj1 = (PathCondition)in.readObject();
				list1.add(obj1);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	private  static PathCondition getPA(int i,String s){

		File file = new File(s+i);
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			try {
				PathCondition obj1 = (PathCondition)in.readObject();
				return obj1;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return null;
	}
//	public static void getAllFiles(File path, List<String> list) {
//		if (path.isFile()) {
//			// 如果是文件
//			if (path.getName().matches("^.+\\.java$")) {
//				// 用正则表达式并且是java文件加入list
//				list.add(path.getAbsolutePath());
//			}
//		} else {
//			// 这里加入一个过滤，过滤掉非java文件，只保留java文件和文件夹
//			File[] fileAry = path.listFiles();
//			if (fileAry == null || fileAry.length == 0) {
//				return;
//			}
//			for (File file : fileAry) {
//				getAllFiles(file, list);
//			}
//		}
//	}

}
