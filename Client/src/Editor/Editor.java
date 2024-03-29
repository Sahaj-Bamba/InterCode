package Editor;

import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Editor {

	@FXML
	private SwingNode swingContainer;

	String[] fonts;

	private SupportedKeywords kw = new SupportedKeywords();
	private HighlightText languageHighlighter = new HighlightText(Color.GRAY);
	AutoComplete autocomplete;

	/*      ShortCuts       */

//	public static final KeyCombination clearShortcut = new KeyCodeCombination(KeyCode.D, KeyCombination.CONTROL_DOWN);


	private JTextArea textArea;

	public JTextArea getEditor() {
		return this.textArea;
	}


	public void initialize() {

		textArea = new JTextArea("", 100, 200);
		textArea.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textArea.setTabSize(2);
		textArea.setLineWrap(true);




		/*      Setting constants       */

		fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();


		/*      Text Area actions       */

		/*      Text Highlight Feature      */

		textArea.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				languageHighlighter.highLight(textArea, kw.getKeywords());
			}
		});

		/*          Auto Complete       */

		autocomplete = new AutoComplete(textArea, new ArrayList(Arrays.asList(kw.getKeywords())));

		/*              Auto Complete       */

		textArea.getDocument().addDocumentListener(autocomplete);



		/*      Putting text area on scroll on Anchor pane      */

		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setWrapStyleWord(true);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		swingContainer.setContent(scrollPane);

	}

	public void clear(ActionEvent actionEvent) {
		textArea.setText("");
	}

	public void changeStyle(ActionEvent actionEvent) {

		String p = fonts[new Random().nextInt(20)];
		//Getting size of the current font or text
		int s = textArea.getFont().getSize();
		textArea.setFont(new Font(p, Font.PLAIN, s));

	}

	public void findReplace(ActionEvent actionEvent) {
		Stage window = new Stage();

		//Block events to other windows

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Find Replace");

		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("../Editor/find.fxml"));
		try {
			Parent parent = fxmlLoader.load();
			_Find _find = fxmlLoader.getController();
			Scene scene = new Scene(parent);
			window.setScene(scene);
			window.show();
			_find.setTxt(textArea);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void itallic(ActionEvent actionEvent) {
		int sizeOfFont = textArea.getFont().getSize();
//		String fontFamily = textArea.getFont().getFamily();
//		sizeOfFont += 1;
		String fontFamily = textArea.getFont().getFamily();
//		String fontFamily = textArea.getFont().getFamily();
		int fontStyle = textArea.getFont().getStyle();
		if (fontStyle == Font.ITALIC){
			fontStyle = Font.PLAIN;
		}else {
			fontStyle = Font.ITALIC;
		}
		Font font1 = new Font(fontFamily, fontStyle, sizeOfFont);
		textArea.setFont(font1);

	}

	public void bold(ActionEvent actionEvent) {
		int sizeOfFont = textArea.getFont().getSize();
//		String fontFamily = textArea.getFont().getFamily();
//		sizeOfFont += 1;
		String fontFamily = textArea.getFont().getFamily();
		int fontStyle = textArea.getFont().getStyle();
		if (fontStyle == Font.BOLD){
			fontStyle = Font.PLAIN;
		}else {
			fontStyle = Font.BOLD;
		}
		Font font1 = new Font(fontFamily, fontStyle, sizeOfFont);
		textArea.setFont(font1);

	}

	public void increaseSIze(ActionEvent actionEvent) {
		int sizeOfFont = textArea.getFont().getSize();
//		String fontFamily = textArea.getFont().getFamily();
		sizeOfFont += 1;
		String fontFamily = textArea.getFont().getFamily();
		int fontStyle = textArea.getFont().getStyle();
		Font font1 = new Font(fontFamily, fontStyle, sizeOfFont);
		textArea.setFont(font1);

	}

	public void decreaseSize(ActionEvent actionEvent){
		int sizeOfFont = textArea.getFont().getSize();
//		String fontFamily = textArea.getFont().getFamily();
		sizeOfFont -= 1;
		if (sizeOfFont<2){
			sizeOfFont = 2;
		}
		String fontFamily = textArea.getFont().getFamily();
		int fontStyle = textArea.getFont().getStyle();
		Font font1 = new Font(fontFamily, fontStyle, sizeOfFont);
		textArea.setFont(font1);

	}

	public void find(ActionEvent actionEvent){

		new Find(textArea);

	}



















	/*

        ArrayList<String> arrayList;
        String[] list = kw.getSupportedLanguages();

        for (int i = 0; i < list.length; i++) {
            if (file.getName().endsWith(list[i])) {
                switch (i) {
                    case 0:
                        String[] jk = kw.getJavaKeywords();
                        arrayList = kw.setKeywords(jk);
                        autocomplete = new AutoComplete(this, arrayList);
                        textArea.getDocument().addDocumentListener(autocomplete);
                        hasListener = true;
                        break;
                    case 1:
                        String[] ck = kw.getCppKeywords();
                        arrayList = kw.setKeywords(ck);
                        autocomplete = new AutoComplete(this, arrayList);
                        textArea.getDocument().addDocumentListener(autocomplete);
                        hasListener = true;
                        break;
                }
            }
        }


	 */









}
