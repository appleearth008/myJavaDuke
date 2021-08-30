import edu.duke.*;
import edu.duke.Point;
import java.io.File;

public class PerimeterRunner {

    public double getPerimeter(Shape s){
        double totalPerim = 0;
        Point prevPoint = s.getLastPoint();
        for(Point currPt : s.getPoints()){
            double currDis = currPt.distance(prevPoint);
            totalPerim += currDis;
            prevPoint = currPt;
        }
        return totalPerim;
    }

    public void testPerimeter(){
        FileResource fr = new FileResource("src/example1.txt");
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("The shape's perimeter is: " + length);
        int numPoints = getNumPoints(s);
        System.out.println("The number of points in this shape is: " + numPoints);
        double aveLength = getAverageLength(s);
        System.out.println("The average of perimeter of this shape is: " + aveLength);
        double largestLength = getLargestSide(s);
        System.out.println("The length of the largest side of this shape is: " + largestLength);
        double largetX = getLargestX(s);
        System.out.println("The largest X value of this shape is: " + largetX);
    }

    public void testPerimeterMultipleFiles(){
        double largestPeri = getLargestPerimeterMultipleFiles();
        System.out.println("The value of larget perimeter of all selected files is: " + largestPeri);
    }

    public double getLargestPerimeterMultipleFiles(){
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0;
        for (File f: dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if(getPerimeter(s) > largestPerimeter){
                largestPerimeter = getPerimeter(s);
            }
        }
        return largestPerimeter;
    }

    public void testFileWithLargestPerimeter(){
        String nameFile = getFileWithLargestPerimeter();
        System.out.println("The name of the largest perimeter in selected files is: " + nameFile);
    }

    public String getFileWithLargestPerimeter(){
        DirectoryResource dr = new DirectoryResource();
        String fileName = "";
        double largestPerimeter = 0;
        for (File f: dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            if(getPerimeter(s) > largestPerimeter){
                fileName = f.getName();
            }
        }
        return fileName;
    }

    public int getNumPoints(Shape s){
        Iterable<Point> points = s.getPoints();
        int numPoints = 0;
        for(Point p: points ){
            numPoints += 1;
        }
        return numPoints;
    }

    public double getAverageLength(Shape s){
        return getPerimeter(s) / getNumPoints(s);
    }

    public double getLargestSide(Shape s){
        double largetsLength = 0;
        Point prevPt = s.getLastPoint();
        for(Point currPt: s.getPoints()){
            double currLength = prevPt.distance(currPt);
            if (currLength > largetsLength ){
                largetsLength = currLength;
            }
            prevPt = currPt;
        }
        return largetsLength;
    }

    public double getLargestX(Shape s){
        Point lastPoint = s.getLastPoint();
        double largetX = lastPoint.getX();
        for(Point p : s.getPoints()){
            if(p.getX() > largetX){
                largetX = p.getX();
            }
        }
        return largetX;
    }

    public static void main(String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
//        pr.testPerimeter();
//        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
