import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by njp on 2016/5/12.
 */
public class SampleCV {

    public static void main(String[] args) {



   /*     System.loadLibrary( Core.NATIVE_LIBRARY_NAME );*/

        String path = "C:\\SOFTWARE\\opencv\\build\\java\\x64\\opencv_java310.dll";
        System.load(path);

        //读取图像，不改变图像的原始信息
        Mat m = Imgcodecs.imread("C:\\Users\\njp\\Desktop\\109.jpg",Imgcodecs.CV_LOAD_IMAGE_COLOR);

        //将图片转换成灰度图片
        Mat gray = new Mat(m.size(), CvType.CV_8UC1);
        Imgproc.cvtColor(m,gray,Imgproc.COLOR_RGB2GRAY);

        //计算灰度直方图
        List<Mat> images = new ArrayList<Mat>();
        images.add(gray);

        MatOfInt channels= new MatOfInt(0);
        MatOfInt histSize = new MatOfInt(256);
        MatOfFloat ranges= new MatOfFloat(0,256);
        Mat hist = new Mat();
        Imgproc.calcHist(images, channels, new Mat(), hist, histSize, ranges);

        //mat求和
        System.out.println(Core.sumElems(hist));

        //保存转换的图片
        Imgcodecs.imwrite("C:\\Users\\njp\\Desktop\\109.opencv.jpg",gray);

    }
}