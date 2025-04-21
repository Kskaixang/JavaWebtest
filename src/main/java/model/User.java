package model;

public class User {
	private String userName;
	private String gender;
	private Integer age;
	private Double height;
	private Double weight;
	private Double bmiValue; //自建欄位
	private String Result;
	
	
	public User(String userName, String gender, String age, String height, String weight) {
		
		this.userName = userName;
		this.gender = gender;
		this.age = Integer.parseInt(age);
		this.height = Double.parseDouble(height);
		this.weight = Double.parseDouble(weight);
		this.bmiValue = this.weight / Math.pow(this.height/100,2);
		setResult();
        
		
	}
	
	private void setResult() {
		double min =0, max =0;
		switch(gender) {
			case "male":
				min=14.7;
				max=23.3;
				break;
			case "female":
				min=17.1;
				max=22.7;
				break;	
		}
		String Result = bmiValue < min ? "過輕" : (bmiValue > max) ? "過重" : "正常";
		this.Result = Result;
		
		
	}
	public String getResult() {
		return Result;
	}


	public Double getBmiValue() {
		return bmiValue;
	}


	public String getUserName() {
		return userName;
	}


	public String getGender() {
		return gender;
	}


	public Integer getAge() {
		return age;
	}


	public Double getHeight() {
		return height;
	}


	public Double getWeight() {
		return weight;
	}


	@Override
	public String toString() {
		return "User [userName=" + userName + ", gender=" + gender + ", age=" + age + ", height=" + height + ", weight="
				+ weight + ", bmivalue=" + bmiValue + "]";
	}

	
	
	
	
	
	
	

	
	
}
