import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class main {
	private static int[][] Distance = null;

	// Read Distance File
	public static int[][] ReadDistanceFile(String filepath) {
		try {
			FileReader fr = new FileReader(filepath);
			BufferedReader br = new BufferedReader(fr);
			String line;
			line = br.readLine();
			int locnum = Integer.parseInt(line);
			Distance = new int[locnum][];
				
			int locindex = 0;
			while((line = br.readLine()) != null) {
			    Distance[locindex] = new int[locnum];
				String[] distanceData = line.split(",");
				for(int i = 0; i < locnum; i++){
					Distance[locindex][i] = Integer.parseInt(distanceData[i]);
				}
				System.out.println(Arrays.toString(Distance[locindex]));
				locindex += 1;
			}
			
			br.close();
		}

		catch(IOException e) {
		    System.out.println(e);
		}
		
		return Distance;
	}

//	// read file of detail data
//	private static List<List> ReadFile(String filepath){
//		List<List> Detail = new ArrayList<>();
//		List<Integer> Workload = new ArrayList<>();
//		List<List> OtherData = new ArrayList<>();
//		List<Float> Gamma = new ArrayList<>();
//		
//		try {
//			FileReader fr = new FileReader(filepath);
//			BufferedReader br = new BufferedReader(fr);
//			String line;
//			while((line = br.readLine()) != null) {
//				if(line.contains("workload")) {
//					String[] workloadData = line.split(",");
//					Workload.add(Integer.parseInt(workloadData[1]));
//				}
//				else if(line.contains("gamma")) {
//					String[] gammaData = line.split(",");
//					Gamma.add(Float.parseFloat(gammaData[1]));
//					
//				}
//				else if(line.contains("index")) {
//					;
//				}
//				else {
//					List<Integer> DetailData = new ArrayList<>();  // rewards, penalty, etc
//					String[] detailData = line.split(",");
//					for(int i = 0; i < detailData.length; i++){
//						if(i > 2) {
//							DetailData.add(Integer.parseInt(detailData[i]));
//						}
//					}
//					OtherData.add(DetailData);
//				}
//	        }
//			Detail.add(Workload);
//			Detail.add(Gamma);
//			Detail.add(OtherData);
//			br.close();
//		}
//	    catch(IOException e) {
//	    	System.out.println(e);
//	    }
//		
//		return Detail;
//	}
//

	public static void main(String[] args) {
//		// read detail file
//		String detailpath = "C:\\Users\\admin\\workspace\\greedy\\src\\161018_real_data.txt";
//		System.out.print(ReadFile(detailpath));
//		
//		// task assignment
//		List<List> Schedule = TaskAssign(ReadFile(detailpath));
//		System.out.println(Schedule);
		
//		for(int i = 0; i < Schedule.size(); i++){
//			TaskSequence TaskSequence = new TaskSequence(Schedule.get(i));
////			TaskSequence.setUsed();
//
//			String distancepath = "C:\\Users\\admin\\workspace\\greedy\\src\\161018_real_data_distance.txt";
//			int length = 19;
//			TaskSequence.Sequence(TaskSequence.ReadDistanceFile(distancepath, length));
//		}
	}
} 
