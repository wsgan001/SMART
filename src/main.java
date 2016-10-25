import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class main {
	// read file of detail data
	private static List<List> ReadFile(String filepath){
		List<List> Detail = new ArrayList<>();
		List<Integer> Workload = new ArrayList<>();
		List<List> OtherData = new ArrayList<>();
		List<Float> Gamma = new ArrayList<>();
		
		try {
			FileReader fr = new FileReader(filepath);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null) {
				if(line.contains("workload")) {
					String[] workloadData = line.split(",");
					Workload.add(Integer.parseInt(workloadData[1]));
				}
				else if(line.contains("gamma")) {
					String[] gammaData = line.split(",");
					Gamma.add(Float.parseFloat(gammaData[1]));
					
				}
				else if(line.contains("taskId")) {
					;
				}
				else {
					List<Integer> DetailData = new ArrayList<>();  // rewards, penalty, etc
					String[] detailData = line.split(",");
					for(int i = 0; i < detailData.length; i++){
						if(i > 2) {
							DetailData.add(Integer.parseInt(detailData[i]));
						}
					}
					OtherData.add(DetailData);
				}
	        }
			Detail.add(Workload);
			Detail.add(Gamma);
			Detail.add(OtherData);
			br.close();
		}
	    catch(IOException e) {
	    	System.out.println(e);
	    }
		
		return Detail;
	}

	// read data for distance file
	private static List<List> ReadDistanceFile(String filepath, int length) {
		List<List> Distance = new ArrayList<List>();

		try {
			FileReader fr = new FileReader(filepath);
			BufferedReader br = new BufferedReader(fr);
			String line;
			line = br.readLine();
	        while((line = br.readLine()) != null) {
	        	List<Integer> SingleDistance = new ArrayList<Integer>();
				String[] distanceData = line.split(",");
				for(int i = 0; i < distanceData.length; i++){
					SingleDistance.add(Integer.parseInt(distanceData[i]));
				}
				Distance.add(SingleDistance);
	        }
			
			br.close();
		}
	    catch(IOException e) {
	    	System.out.println(e);
	    }
		
		return Distance;
	}


	public static void main(String[] args) {
		// read detail file
//		String detailpath = "C:\\Users\\admin\\workspace\\greedy\\src\\161018_real_data.txt";
		String detailpath = "/Users/linda/Desktop/專題/greedy/src/data_1018.txt";
//		System.out.print(ReadFile(detailpath));
		
		// task assignment
		TaskAssign TaskAssign = new TaskAssign(ReadFile(detailpath));
		List<List> Schedule = TaskAssign.getSchedule();
		System.out.println("Schedule:\n" + Schedule);
//		System.out.println("Unassigned tasks:\n" + TaskAssign.getUnassignedTasks());
		
		for(int i = 0; i < Schedule.size(); i++){
			TaskSequence TaskSequence = new TaskSequence(Schedule.get(i));
			TaskSequence.setUsed();

			String distancepath = "C:\\Users\\admin\\workspace\\greedy\\src\\161018_real_data_distance.txt";
			int length = 19;
			TaskSequence.Sequence(TaskSequence.ReadDistanceFile(distancepath, length));
		}
	}
} 
