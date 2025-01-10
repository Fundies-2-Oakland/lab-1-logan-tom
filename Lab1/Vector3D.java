import javax.imageio.ImageTranscoder;
import java.lang.Math;

public class Vector3D{
    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public double getZ(){
        return this.z;
    }

    public String toString(){
        return "( " + this.x + " " + this.y + " " + this.z + ")";
    }
    public double getMagnitude(){
        double sumedSquare = (Math.pow(this.x,2) + Math.pow(this.y,2) + Math.pow(this.z,2));
        return Math.pow(sumedSquare,.5);
    }
    public Vector3D normalize(){
        double sum = this.x + this.y + this.z;
        if(sum == 0){
            throw new IllegalStateException("division by 0");
        }
        return new Vector3D(this.x/ sum,this.y/sum,this.z/sum );
    }

    public Vector3D add(Vector3D other){
        return new Vector3D(this.x + other.getX(), this.y + other.getY(), this.z + other.getZ());
    }

    public  Vector3D multiply(double scale){
        return new Vector3D(this.x * scale, this.y * scale, this.z * scale);
    }

    public double dotProduct(Vector3D other){
        return this.x * other.getX() + this.y * other.getY() + this.z * other.getZ();
    }

    public double angleBetween(Vector3D other){
        return Math.acos(this.dotProduct(other) / (getMagnitude() * other.getMagnitude()));
    }

    public Vector3D crossProduct(Vector3D other){
        return new Vector3D(this.y * other.getZ() - this.z * other.getY(), this.z * other.getX() - this.x * other.getZ(), this.x * other.getY() - this.y * other.getX());
    }



    public static void main(String[] args){
        Vector3D test = new Vector3D(1,2,3);
        System.out.println(test.getX());
        System.out.println(test.getY());
        System.out.println(test.getZ());
        System.out.println(test.toString());
        System.out.println(test.getMagnitude());
        System.out.println(test.normalize());
        System.out.println(test.multiply(3.5));
        Vector3D test2 = new Vector3D(4,5,6);
        System.out.println(test.add(test2));
        System.out.println(test.dotProduct(test2));
        System.out.println(test.angleBetween(test2));
        System.out.println(test.crossProduct(test2));

    }
}

