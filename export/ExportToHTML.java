package export;

import data.Data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Latitude on 17.8.2016.
 */
public class ExportToHTML {

    private String path;

    public ExportToHTML(String pathToNewFile) {
        path = pathToNewFile;
    }

    public void create(List<Data> data) throws IOException {

        File file = new File(path);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("</head>");
        sb.append("<table align=\"center\" border=\"1\" cellpadding=\"6\" cellspacing=\"0\">");
        sb.append("<tr><td>Vendor</td><td>Units</td><td>Share</td></tr>");
        for (Data dat : data) {
            sb.append("<tr>");
            sb.append("<td> " + dat.getVendor() + " </td>");
            sb.append("<td> " + dat.getUnits() + " </td>");
            sb.append("<td> " + dat.getUnits() / data.get((data.size() - 1)).getUnits() * 100 + " </td>");
            sb.append("</tr>");
        }
        sb.append("</table>");
        sb.append("</body>");
        sb.append("</html>");

        bw.write(sb.toString());
        bw.flush();

        bw.close();
    }
}
