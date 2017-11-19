package cn.happy.j_servlet;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by linlin on 2017/10/8.
 */
public class MoreFileUploadActionTwo extends ActionSupport {
    private List<File> upload;
    private List<String> uploadContentType;
    private List<String> uploadFileName;
    private String savePath;

    @Override
    public String execute() throws Exception {
        byte[] buffer = new byte[1024];
     /*   File file=new File(getSavePath());
        if(!file.exists()){
            file.mkdirs();
        }*/
        int index = 0;
        for (File item : upload) {
            FileInputStream fis = new FileInputStream(item);
            FileOutputStream fos = new FileOutputStream(getSavePath() + "\\" + getUploadFileName().get(index++));
            int length = fis.read(buffer);
            while (length > 0) {
                fos.write(buffer, 0, length);
                length = fis.read(buffer);
            }
            fos.flush();
            fos.close();
            fis.close();

        }

        return SUCCESS;
    }

    public List<File> getUpload() {
        return upload;
    }

    public void setUpload(List<File> upload) {
        this.upload = upload;
    }

    public List<String> getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(List<String> uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public List<String> getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(List<String> uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getSavePath() {
        return ServletActionContext.getServletContext().getRealPath(savePath);
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
}
