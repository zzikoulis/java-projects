package exercises.week8.app;

import exercises.week8.model.PointXYZ;

public class ProjectPointApp {

    public static void main(String[] args) {
        PointXYZ p1 = new PointXYZ();
        PointXYZ p2 = new PointXYZ(1, 2 , 3);
        PointXYZ p3 = PointXYZ.probableZero();

        System.out.println(p1.convertToString());
        System.out.println(p1.getX());
        p1.setX(100);

        System.out.println(p1.convertToString());
        System.out.println(p2.convertToString());
        System.out.println(p3.convertToString());
    }
}
