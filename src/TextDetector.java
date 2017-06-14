import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;

/**
 * Created by lucabonfante
 */
public class TextDetector {

    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }
    CascadeClassifier textDetector;

    private void loadCascade() {
        String cascadePath = "/Users/lucabonfante/Desktop/TextDetection/mytextdetector.xml";
        textDetector = new CascadeClassifier(cascadePath);
    }

    private void detectAndDrawText(Mat image) {
        MatOfRect textDetections = new MatOfRect();
        textDetector.detectMultiScale(image, textDetections);
        for (Rect rect : textDetections.toArray()) {
            Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x
                    + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
        }
    }

    public static void main(String[] args) throws IOException {
        TextDetector a = new TextDetector();

        File input = new File("/Users/lucabonfante/Desktop/TextDetection/t.png");

        BufferedImage image1 = ImageIO.read(input);
        BufferedImage imageCopy = new BufferedImage(image1.getWidth(), image1.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        imageCopy.getGraphics().drawImage(image1, 0, 0, null);

        byte[] data = ((DataBufferByte) imageCopy.getRaster().getDataBuffer()).getData();
        Mat image = new Mat(image1.getHeight(),image1.getWidth(), CvType.CV_8UC3);
        image.put(0, 0, data);

        a.loadCascade();
        a.detectAndDrawText(image);
    }

}
