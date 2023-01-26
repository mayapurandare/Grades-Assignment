class Grades {
  private int[] values;
  
  Grades() { // default constructor
    //values = {0};
  }
  
  Grades(int[] myArray) {
    this.values = myArray;
  }
  
  public void setValues(int[] myArray) { // set values declaration
    for (int i = 0; i < myArray.length; i++) {
      values[i] = myArray[i];
    }
  }
  
  public int[] getValues() { 
    return values;// returns values array
  }
    
  public int highest() {// returns the highest value in array 
    int high = values[0];
    for (int i = 0; i < values.length; i++) {
      if (values[i] > high) {
        high = values[i];
      }
    }
    return high;
  }
    
  public int lowest() { // returns the lowest value in array 
    int low = values[0];
    for (int i = 0; i < values.length; i++) {
      if (values[i] < low) {
        low = values[i];
      }
    }
    return low;
  }
    
  public int numOfGrades() {// returns the number of grades in array 
    return values.length;
  }
    
  public double average() { // returns the average of array 
    double gradeSum = 0;
    for (int i = 0; i < values.length; i++) {
      gradeSum += values[i];
    }
    return gradeSum / numOfGrades();
    
  }
    
  public int numOfFailingGrades(int gradeValue) { // returns the number of values in the array that are less than input value, gradeValue 
    int count = 0;
    for (int i = 0; i < values.length; i++) {
      if (values[i] < gradeValue) {
        count++;
      }
    }
    return count;
  }

  public void histogram() { // prints the histogram of grades 
    // less than 60
    int subSixty = numOfFailingGrades(60);
    int subSeventy = numOfFailingGrades(70) - subSixty;
    int subEighty = numOfFailingGrades(80) - numOfFailingGrades(70);
    int subNinety = numOfFailingGrades(90) - numOfFailingGrades(80);
    int subHund = numOfFailingGrades(101) - numOfFailingGrades(90);
    System.out.println("90 - 100 | " + "*".repeat(subHund));
    System.out.println("80 - 89  | " + "*".repeat(subNinety));
    System.out.println("70 - 79  | " + "*".repeat(subEighty));
    System.out.println("60 - 69  | " + "*".repeat(subSeventy));
    System.out.println("  < 60   | " + "*".repeat(subSixty));
    
  }
}

// MAIN
class GradesApp {
  public static void main(String[] args) {
    System.out.println("Welcome to your grades app !!");
    try {
      String response = System.console().readLine("How many grades are you entering? ");
      int numOfValues = Integer.parseInt(response);
      if (numOfValues <= 0) {
        throw new IllegalArgumentException("You cannot have a negative number of grades ");
      }
      int[] gradesArray = new int[numOfValues];
      for (int i = 0; i < numOfValues; i++) {
        int gradeResponse = 0;
        int gradeCount = i + 1;
        try {
          String response2 = System.console().readLine("Grade " + gradeCount + ": ");
          gradeResponse = Integer.parseInt(response2);
          if (gradeResponse < 0) {
        throw new IllegalArgumentException("You cannot have a negative number of grades ");
      } else if (gradeResponse > 100) {
                throw new IllegalArgumentException("Grade cannot be higher than 100!");
            }
        } catch (NumberFormatException e) {
            System.err.println("App can only handle integers up to a hundred");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getLocalizedMessage());
        }
        gradesArray[i] = gradeResponse;
      }
      
      Grades g = new Grades(gradesArray);
      g.setValues(gradesArray);
      System.out.println("Highest grade: " + g.highest());
      System.out.println("Lowest grade: " + g.lowest());
      System.out.println("Average grade: " + g.average());
      System.out.println("Number of grades: " + g.numOfGrades());
      System.out.println("Number of failing grades: " + g.numOfFailingGrades(60));
      System.out.println("Histogram: ");
      g.histogram();
    } catch (NumberFormatException e) {
            System.err.println("App can only handle integers up to a hundred");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getLocalizedMessage());
        }
    
    
  }
}

  