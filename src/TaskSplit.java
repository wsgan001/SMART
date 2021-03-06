import java.util.ArrayList;
import java.util.List;


public class TaskSplit{
	private int taskId;
	private float max_rewards;
	private int ideal_day;
	private float possi_percentage;
	private List<Integer> split_to_days;
	private List<Float> split_percentage;
	private float left_unfinished_percentage;
	private int counter;
	
	public TaskSplit(int id){
		taskId = id;
		split_to_days = new ArrayList<>();
		split_percentage = new ArrayList<>();
		left_unfinished_percentage = 1;
		max_rewards = 0;
		ideal_day = 0;
		possi_percentage = 0;
		counter = 0;
	}
	
	public TaskSplit(int id, float rewards, int day, float possi_percentage){
		taskId = id;
		max_rewards = rewards;
		ideal_day = day;
		this.possi_percentage = possi_percentage;
		split_to_days = new ArrayList<>();
		split_percentage = new ArrayList<>();
		left_unfinished_percentage = 1;
		counter = 0;
	}

	public void setDetails(float rewards, int day, float possi_percentage){
		max_rewards = rewards;
		ideal_day = day;
		this.possi_percentage = possi_percentage;
	}

	public int getTaskId(){
		return taskId;
	}
	
	public float getMaxRewards(){
		return max_rewards;
	}
	
	public int getIdealDay(){
		return ideal_day;
	}
	
	public float getPossiPercentage(){
		return possi_percentage;
	}

	public float getUnfinishedPercentage(){
		return left_unfinished_percentage;
	}
	
	public void splitInto(int day, float percentage){
		split_to_days.add(day);
		split_percentage.add(percentage);
		left_unfinished_percentage -= percentage;
		counter++;
	}
	
	public float getPercentage(int day){
		float percentage = 0;
		if(split_to_days.contains(day)){
			percentage = split_percentage.get(split_to_days.indexOf(day));
		}
		return percentage;
	}
	
	public int getCounter(){
		return counter;
	}
}
