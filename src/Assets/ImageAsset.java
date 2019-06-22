package Assets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;

public class ImageAsset {
	private static ImageAsset imageAsset;
	private HashMap<String, BufferedImage> backgrounds = new HashMap<String, BufferedImage>();
	private HashMap<String, BufferedImage> items = new HashMap<String, BufferedImage>();

	private HashMap<String, BufferedImage> equipment = new HashMap<String, BufferedImage>();
	private HashMap<String, BufferedImage> characters = new HashMap<String, BufferedImage>();
	private HashMap<String, BufferedImage> UIElements = new HashMap<String, BufferedImage>();
	private HashMap<String, ArrayList<BufferedImage> > submarines = new HashMap<String, ArrayList<BufferedImage>>();
	private HashMap<String, ArrayList<BufferedImage> > urchins = new HashMap<String, ArrayList<BufferedImage>>();
	private HashMap<String, ArrayList<BufferedImage> > aaFishes = new HashMap<String, ArrayList<BufferedImage>>();
	private HashMap<String, ArrayList<BufferedImage> > effects = new HashMap<String, ArrayList<BufferedImage>>();
	public static ImageAsset createImageAsset() throws IOException {
		if(imageAsset==null){
			imageAsset = new ImageAsset();
		}
		return imageAsset;
	}
	private ImageAsset() throws IOException {
		initialize();
	}
	private void initialize() throws IOException {
		loadBackgrounds();
		loadUIElements();
		loadSubmarines();
		loadUrchin();
		loadEquipment();
		loadCharacters();
		loadFishes();
		loadEffects();
		loadItems();
	}



	private void loadItems() throws IOException {
		items.put("friedFish", loadBufferedImage("src\\Assets\\Images\\items\\friedFish.png"));
		loadGems();
	}
	private void loadGems() throws IOException {
		items.put("redGem", loadBufferedImage("src\\Assets\\Images\\items\\gems\\gemBlue.png"));
		items.put("blueGem", loadBufferedImage("src\\Assets\\Images\\items\\gems\\gemRed.png"));
		items.put("greenGem", loadBufferedImage("src\\Assets\\Images\\items\\gems\\gemGreen.png"));
		
	}
	private void loadUrchin() throws IOException {
		urchins.put("urchin",loadUrchinFrames());		
	}
	private void loadFishes() throws IOException {
		loadAAFish();
	}
	private void loadAAFish() throws IOException {
		ArrayList<BufferedImage> fishe = new ArrayList<BufferedImage>();

		for(int i = 1 ; i < 14 ;i++){

			if(i<10){BufferedImage fishFrame = (BufferedImage) ImageIO.read(new File("src\\Assets\\Images\\Fishes\\aa\\anglerfish0"+i+".png"));
			fishe.add(fishFrame);
			}
			if(i>=10){
				BufferedImage fishFrame = (BufferedImage) ImageIO.read(new File("src\\Assets\\Images\\Fishes\\aa\\anglerfish"+i+".png"));
				fishe.add(fishFrame);
			}
		}
		aaFishes.put("11Fish", fishe);

	}
	private void loadBackgrounds() throws IOException {
		backgrounds.put("menueBackground",loadBufferedImage("src\\Assets\\Images\\backgrounds\\menueBackground.png") );
		backgrounds.put("gameBackground", loadBufferedImage("src\\Assets\\Images\\backgrounds\\gameBackground.png"));
		backgrounds.put("dialoguePanelBackground",  loadBufferedImage("src\\Assets\\Images\\backgrounds\\dialoguePanelBackground.png"));
	}
	private void loadUIElements() throws IOException {
		loadButtons();
		UIElements.put("cursor", loadBufferedImage("src\\Assets\\Images\\UIElements\\cursor.png"));
		UIElements.put("dataBar", loadBufferedImage("src\\Assets\\Images\\UIElements\\dataBar.png"));
		UIElements.put("upperBar", loadBufferedImage("src\\Assets\\Images\\UIElements\\upperBar.png"));
		UIElements.put("pearl", loadBufferedImage("src\\Assets\\Images\\UIElements\\pearl.png"));

	}
	private void loadSubmarines() throws IOException {
		submarines.put("red", loadSubmarineFrames("Red"));

	}
	private void loadEquipment() throws IOException {
		equipment.put("bullet", loadBufferedImage("src\\Assets\\Images\\equipment\\bullet.png"));
		equipment.put("missile", loadBufferedImage("src\\Assets\\Images\\equipment\\missile.png"));

	}
	private void loadEffects() throws IOException {
		effects.put("explosion", loadExplosionFrames());
		effects.put("overHeat", loadOverHeatFrames());

	}


	private void loadCharacters() throws IOException {
		characters.put("star", loadBufferedImage("src\\Assets\\Images\\characters\\star.png"));
		characters.put("crab", loadBufferedImage("src\\Assets\\Images\\characters\\crab.png"));
		characters.put("LockedPink", loadBufferedImage("src\\Assets\\Images\\Submarine\\Pink\\LockedPink.png"));
		characters.put("LockedGreen", loadBufferedImage("src\\Assets\\Images\\Submarine\\Green\\LockedGreen.jpg"));
	}



	private void loadButtons() throws IOException {
		UIElements.put("okButton", loadBufferedImage("src\\Assets\\Images\\UIElements\\okButton.png"));
		UIElements.put("cancelButton", loadBufferedImage("src\\Assets\\Images\\UIElements\\cancelButton.png"));
		UIElements.put("escapePanelExiteButton", loadBufferedImage("src\\Assets\\Images\\UIElements\\escapePanelExiteButton.png"));
		UIElements.put("escapePanelContinueButton", loadBufferedImage("src\\Assets\\Images\\UIElements\\escapePanelContinueButton.png"));
		UIElements.put("menuePanelContinueButton", loadBufferedImage("src\\Assets\\Images\\UIElements\\menuePanelContinueButton.png"));
		UIElements.put("escapePanelContinueButton", loadBufferedImage("src\\Assets\\Images\\UIElements\\escapePanelContinueButton.png"));
		UIElements.put("newGameButton", loadBufferedImage("src\\Assets\\Images\\UIElements\\newGameButton.png"));
		UIElements.put("returnButton", loadBufferedImage("src\\Assets\\Images\\UIElements\\returnButton.png"));
		UIElements.put("ratingButton", loadBufferedImage("src\\Assets\\Images\\UIElements\\ratingButton.png"));
		UIElements.put("optionsButton", loadBufferedImage("src\\Assets\\Images\\UIElements\\optionsButton.png"));
		UIElements.put("menuePanelExiteButton", loadBufferedImage("src\\Assets\\Images\\UIElements\\menuePanelExiteButton.png"));
		UIElements.put("startButton", loadBufferedImage("src\\Assets\\Images\\UIElements\\startButton.png"));
		UIElements.put("removeButton", loadBufferedImage("src\\Assets\\Images\\UIElements\\removeButton.png"));
		UIElements.put("addButton", loadBufferedImage("src\\Assets\\Images\\UIElements\\addButton.png"));
		UIElements.put("buttonExit", loadBufferedImage("src\\Assets\\Images\\UIElements\\buttonExit.png"));
	}

	public BufferedImage loadBufferedImage(String path) throws IOException{
		return ImageIO.read(new File(path));
	}


	public HashMap<String, BufferedImage> getBackgrounds() {
		return backgrounds;
	}

	public HashMap<String, BufferedImage> getEquipment() {
		return equipment;
	}

	public HashMap<String, BufferedImage> getCharacters() {
		return characters;
	}

	public HashMap<String, BufferedImage> getUIElements() {
		return UIElements;
	}

	public HashMap<String, ArrayList<BufferedImage>> getSubmarines() {
		return submarines;
	}
	public HashMap<String, ArrayList<BufferedImage>> getFishes() {
		return aaFishes;
	}

	public HashMap<String, ArrayList<BufferedImage>> getEffects() {
		return effects;
	}
	public HashMap<String, ArrayList<BufferedImage>> getUrchins() {
		return urchins;
	}
	private  ArrayList<BufferedImage> loadOverHeatFrames() throws IOException{
		ArrayList<BufferedImage> OverHeatFrames = new ArrayList<BufferedImage>();

		for(int i = 0 ; i <15 ; i++){
			BufferedImage OverHeatFrame = ImageIO.read(new File("src\\Assets\\Images\\effects\\overHeatFrames\\blackSmoke"+i+".png"));
			OverHeatFrames.add(OverHeatFrame);
		}
		return OverHeatFrames;
	}
	private ArrayList<BufferedImage> loadExplosionFrames() throws IOException {
		ArrayList<BufferedImage> explosionFrames = new ArrayList<BufferedImage>();

		for(int i = 3 ; i < 65 ;i++){

			if(i<10){BufferedImage explosionFrame = (BufferedImage) ImageIO.read(new File("src\\Assets\\Images\\effects\\explosionFrames\\image_part_00"+i+".png"));
			explosionFrames.add(explosionFrame);
			}
			if(i>=10){
				BufferedImage explosionFrame = (BufferedImage) ImageIO.read(new File("src\\Assets\\Images\\effects\\explosionFrames\\image_part_0"+i+".png"));
				explosionFrames.add(explosionFrame);
			}
		}		
		return explosionFrames;
	}
	private ArrayList<BufferedImage> loadUrchinFrames() throws IOException {
		ArrayList<BufferedImage> urchinFrames = new ArrayList<BufferedImage>();

		for(int i = 1 ; i < 17 ;i++){
			if(i<10){BufferedImage urchinFrame = (BufferedImage) ImageIO.read(new File("src\\Assets\\Images\\Urchins\\urchin0"+i+".png"));
			urchinFrames.add(urchinFrame);
			}
			if(i>=10){
				BufferedImage explosionFrame = (BufferedImage) ImageIO.read(new File("src\\Assets\\Images\\Urchins\\urchin"+i+".png"));
				urchinFrames.add(explosionFrame);
			}
		}		
		return urchinFrames;
	}

	private  ArrayList<BufferedImage> loadSubmarineFrames(String color) throws IOException{
		ArrayList<BufferedImage> submarineFrames = new ArrayList<BufferedImage>();

		for(int i =0; i< 8; i++){
			BufferedImage submarineFrame = ImageIO.read(new File("src\\Assets\\Images\\Submarine\\"+color+"\\submarine000"+(i+1)+".png"));
			submarineFrames.add(submarineFrame);
		}
		return submarineFrames;}
	public HashMap<String, BufferedImage> getItems() {
		return items;
	}
	public void setItems(HashMap<String, BufferedImage> items) {
		this.items = items;
	}
}