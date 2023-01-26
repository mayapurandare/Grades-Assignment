class Main {
  public static void main(String[] args) {
    int[] gradesArray = new int[3];
    gradesArray[0] = 99;
    gradesArray[1] = 85;
    gradesArray[2] = 75;
    Grades g = new Grades(gradesArray);
    g.setValues(gradesArray);
    System.out.println(g.highest());
    
  }


}