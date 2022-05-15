package exercises.week8.model;

import java.util.Random;

/**
 * The {@link PointXYZ} class depicts a three-dimensional
 * <i>point</i> with <b>x</b>, <b>y</b> and <b>z</b> coordinates
 * that are considered integers. All points such as
 * (0,0,0) or (-100,-100,-100) or (100,100,100) could be
 * instantiated by this class.
 */
public class PointXYZ {
    private int x;
    private int y;
    private int z;

    /**
     * Instantiates a newly created point,
     * so that it depicts a (0,0,0) point
     */
    public PointXYZ() {}


    /**
     * Constructs a new point based on
     * specific x, y, z coordinates
     *
     * @param x     x-coordinate
     * @param y     y-coordinate
     * @param z     z-coordinate
     */
    public PointXYZ(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    /**
     * Constructs a random point
     * @return  a newly created random point
     */
    public static PointXYZ probableZero() {
        Random r = new Random();
        return new PointXYZ(r.nextInt(200) - 100, r.nextInt(200) - 100, r.nextInt(200) - 100);
    }


    /**
     * Provides access to x-coordinate
     * @return      the value of x-coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Mutates x-coordinate
     * @param x     the value of x-coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Provides access to y-coordinate
     * @return      the value of y-coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Mutates y-coordinate
     * @param y     the value of y-coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Provides access to z-coordinate
     * @return      the value of z-coordinate
     */
    public int getZ() {
        return z;
    }

    /**
     * Mutates z-coordinate
     * @param z     the value of z-coordinate
     */
    public void setZ(int z) {
        this.z = z;
    }

    /**
     * Transforms point's state to String
     * @return      the transformed state (x,y,z)
     */
    public String convertToString() {
        return "(" + x + "," + y + "," + z + ")";
    }
}
