package GenerarTXT;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TxtGenerator implements GeneraSalida {
	
	private String txtName;
	private ArrayList<String> content = new ArrayList<>();
	
	public void addToContent(String s) {
		content.add(s);
	}
	
	@Override
	public void generate() {
		try {
			Path file = Paths.get(txtName);
			Files.write(file , content, StandardCharsets.UTF_8);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public List<String> getContent() {
		return content;
	}

	public void setContent(List<String> content) {
		this.content = (ArrayList<String>) content;
	}


	public String getTxtName() {
		return txtName;
	}

	public void setTxtName(String txtName) {
		this.txtName = txtName;
	}
		
}

interface GeneraSalida{
	public void generate();
}
