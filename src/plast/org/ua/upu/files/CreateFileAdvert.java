package plast.org.ua.upu.files;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import plast.org.ua.upu.dao.CostitemDao;
import plast.org.ua.upu.dao.DoctorDao;
import plast.org.ua.upu.dao.EstimateDao;
import plast.org.ua.upu.dao.EventsDao;
import plast.org.ua.upu.dao.KVDao;
import plast.org.ua.upu.dao.KomendantDao;
import plast.org.ua.upu.dao.KurinDao;
import plast.org.ua.upu.dao.OrganizerDao;
import plast.org.ua.upu.dao.StanytsyaDao;
import plast.org.ua.upu.dao.StupinDao;
import plast.org.ua.upu.dao.TypeDoctorDao;
import plast.org.ua.upu.dao.VyshkilDao;
import plast.org.ua.upu.idao.ICostitemDao;
import plast.org.ua.upu.idao.IDoctorDao;
import plast.org.ua.upu.idao.IEstimateDao;
import plast.org.ua.upu.idao.IEventsDao;
import plast.org.ua.upu.idao.IKVDao;
import plast.org.ua.upu.idao.IKomendantDao;
import plast.org.ua.upu.idao.IKurinDao;
import plast.org.ua.upu.idao.IOrganizerDao;
import plast.org.ua.upu.idao.IStanystyaDao;
import plast.org.ua.upu.idao.IStupinDao;
import plast.org.ua.upu.idao.ITypeDoctorDao;
import plast.org.ua.upu.idao.IVyshkilDao;
import plast.org.ua.upu.table.Costitem;
import plast.org.ua.upu.table.Doctor;
import plast.org.ua.upu.table.Estimate;
import plast.org.ua.upu.table.Events;
import plast.org.ua.upu.table.KV;
import plast.org.ua.upu.table.Komendant;
import plast.org.ua.upu.table.Kurin;
import plast.org.ua.upu.table.Organizer;
import plast.org.ua.upu.table.Stanytsya;
import plast.org.ua.upu.table.Stupin;
import plast.org.ua.upu.table.TypeDoctor;
import plast.org.ua.upu.table.Vyshkil;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


public class CreateFileAdvert {
	private IEventsDao eventsDao = EventsDao.getInstance();
	private IKomendantDao komendantDao = KomendantDao.getInstance();
	private IStupinDao stupinDao = StupinDao.getInstance();
	private IStanystyaDao stanystyaDao = StanytsyaDao.getInstance();
	private IKurinDao kurinDao = KurinDao.getInstance();
	private IVyshkilDao vyshkilDao = VyshkilDao.getInstance();
	private IKVDao kvDao = KVDao.getInstance();
	private IOrganizerDao organizerDao = OrganizerDao.getInstance();
	private IDoctorDao doctorDao = DoctorDao.getInstance();
	private ITypeDoctorDao typeDoctorDao = TypeDoctorDao.getInstance();
	private IEstimateDao estimateDao = EstimateDao.getInstance();
	private ICostitemDao costitemDao = CostitemDao.getInstance();
	private List<Events> litsEvent;
	private List<Komendant> listKomendant;
	private List<Stupin> listStupin;
	private List<Stanytsya> listStan;
	private List<Kurin> listKurin; 
	private List<Vyshkil> listVyshkil;
	private List<KV> listKV;
	private List<Organizer> listOrgan;
	private List<Doctor> listDoctor;
	private List<TypeDoctor> listTypeDoc;
	private List<Estimate> listEstimate;
	private List<Costitem> listCostitem;
	private String hashid;
	private Document document;
	private Paragraph paragraph;
	private BaseFont baseArial;
	private BaseFont baseTimes;
	private Font font;
	private Font boltfont;
	private Font boltfontsmall;
	private Date fromDateAdvert; 
	private Date toDateAdvert;
	private Date sysDate;
	private String stupinK;
	private String stanK;
	private String kurinK;
	private String vyshkilK;
	private String kvK;
	private String typeDoc;
	private String costName;
	private PdfPTable table;
	private static final String FILES = "/opt/tomcat/webapps/advertaction/files/";
	//private static final String FILES = "D:\\Java\\advertaction\\WebContent\\files\\";
	private static final String ARIAL_FONT = "arial.ttf";
	private static final String TIMES_FONT = "times.ttf";
	private static final String TAB = "    ";
	public String getHashid() {
		return hashid;
	}

	public void setHashid(String hashid){
		
		try {
			DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
			litsEvent = eventsDao.findAll(hashid);
			for (Events events : litsEvent) {
				
				fromDateAdvert = events.getDatefromadvert();
				toDateAdvert = events.getDatetoadvert();
				sysDate = events.getRegistrdate();
			
			document = new Document(PageSize.A4);
			PdfWriter.getInstance(document, new FileOutputStream(FILES+df.format(sysDate)+"_"+events.getAdvertnameeng()+".pdf")).setStrictImageSequence(true);

			document.open();
			baseArial = BaseFont.createFont(ARIAL_FONT, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			baseTimes = BaseFont.createFont(TIMES_FONT, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			font = new Font(baseTimes, 12, Font.NORMAL);
			boltfont = new Font(baseArial, 20, Font.BOLD);
			boltfontsmall = new Font(baseTimes, 12, Font.BOLD);
			
			paragraph = new Paragraph("ПЛАСТ", boltfont);
			paragraph.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph);
			
			paragraph = new Paragraph("НАЦІОНАЛЬНА СКАУТСЬКА ОРГАНІЗАЦІЯ УКРАЇНИ", boltfont);
			paragraph.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph);
			
			paragraph = new Paragraph("ЗГЛОШЕННЯ ЗАХОДУ", boltfont);
			paragraph.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph);
			
			paragraph = new Paragraph("", boltfont);
			paragraph.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph);
			
			paragraph = new Paragraph();
			paragraph.setAlignment(Element.ALIGN_LEFT);
			paragraph.add(new Chunk("Назва заходу: ",font)); 
			paragraph.add(new Chunk(events.getAdvertname(),boltfontsmall)); 
			document.add(paragraph);
			
			
			String fromDtAdvStr = df.format(fromDateAdvert);
			String toDtAdvStr = df.format(toDateAdvert);
			paragraph = new Paragraph();
			paragraph.setAlignment(Element.ALIGN_LEFT);
			paragraph.add(new Chunk("Дата проведення з: ",font)); 
			paragraph.add(new Chunk(fromDtAdvStr,boltfontsmall)); 
			paragraph.add(new Chunk(" по: ",font));
			paragraph.add(new Chunk(toDtAdvStr,boltfontsmall));
			document.add(paragraph);
			
			paragraph = new Paragraph();
			paragraph.setAlignment(Element.ALIGN_LEFT);
			paragraph.add(new Chunk("Місце проведення: ",font)); 
			paragraph.add(new Chunk(events.getVenue(),boltfontsmall)); 
			document.add(paragraph);
			
			paragraph = new Paragraph();
			paragraph.setAlignment(Element.ALIGN_LEFT);
			paragraph.add(new Chunk("Кількість учасників: ",font)); 
			paragraph.add(new Chunk(events.getNumbparticip().toString(),boltfontsmall)); 
			document.add(paragraph);
			
			paragraph = new Paragraph();
			paragraph.setAlignment(Element.ALIGN_LEFT);
			paragraph.add(new Chunk("Вік учасників: ",font)); 
			paragraph.add(new Chunk(events.getAgeparticipfrom().toString()+"-"+events.getAgeparticipto().toString(),boltfontsmall)); 
			document.add(paragraph);
			
			paragraph = new Paragraph();
			paragraph.setAlignment(Element.ALIGN_LEFT);
			listKomendant = komendantDao.findAll(events.getKomendant().getId());
			for (Komendant komendant : listKomendant) {
				
				listStupin = stupinDao.findKomendant(komendant.getStupin().getId());
				for (Stupin stupin : listStupin) {
					stupinK = stupin.getShortname();
				}
				
				listStan = stanystyaDao.findStanytsya(komendant.getStanytsya().getId());
				for (Stanytsya stanytsya : listStan) {
					stanK = stanytsya.getNamestan();
				}
				if(komendant.getKurin()!=null){
					listKurin = kurinDao.findKurin(komendant.getKurin().getId());
					for (Kurin kurin : listKurin) {
						kurinK = kurin.getNamekurin();
					}
				} else {
					kurinK = "Немає куреня";
				}
				if(komendant.getVyshkil()!= null){
					listVyshkil = vyshkilDao.findVyshkil(komendant.getVyshkil().getId());
					for (Vyshkil vyshkil : listVyshkil) {
						vyshkilK = vyshkil.getName();
					}
				} else {
					vyshkilK = "Немає вишколу";
				}
				if(komendant.getKv()!=null){
					listKV = kvDao.findKV(komendant.getKv().getId());
					for (KV kv : listKV) {
						kvK = kv.getName();
					}
				} else {
					kvK = "Немає КВ";
				}
				paragraph = new Paragraph();
				paragraph.add(new Chunk("Комендант: ",font));
				paragraph.add(new Chunk(stupinK + " " +
									    komendant.getLastname() + " " +
									    komendant.getFirstname()+ ", "+
									    df.format(komendant.getBirthday())+"р.н., ("+
									    countyear(new Date(),komendant.getBirthday())+
									    "р),",boltfontsmall));
				document.add(paragraph);
				
				paragraph = new Paragraph();
				paragraph.add(new Chunk(TAB+TAB+TAB+TAB+TAB+" станиця: ",font));
				paragraph.add(new Chunk(stanK+",",boltfontsmall));
				document.add(paragraph);
				
				paragraph = new Paragraph();
				paragraph.add(new Chunk(TAB+TAB+TAB+TAB+TAB+" курінь: ",font));
				paragraph.add(new Chunk(kurinK+",",boltfontsmall));
				document.add(paragraph);
				
				paragraph = new Paragraph();
				paragraph.add(new Chunk(TAB+TAB+TAB+TAB+TAB+" ступінь в КВ: ",font));
				paragraph.add(new Chunk(kvK+",",boltfontsmall));
				document.add(paragraph);
				
				paragraph = new Paragraph();
				paragraph.add(new Chunk(TAB+TAB+TAB+TAB+TAB+" вишкіл: ",font));
				paragraph.add(new Chunk(vyshkilK+",",boltfontsmall));
				document.add(paragraph);
				
				paragraph = new Paragraph();
				paragraph.add(new Chunk(TAB+TAB+TAB+TAB+TAB+" моб.тел.: ",font));
				paragraph.add(new Chunk(komendant.getCellnumber()+",",boltfontsmall));
				document.add(paragraph);
				
				paragraph = new Paragraph();
				paragraph.add(new Chunk(TAB+TAB+TAB+TAB+TAB+" e-mail: ",font));
				paragraph.add(new Chunk(komendant.getEmail()+",",boltfontsmall));
				document.add(paragraph);
			}
			
			listOrgan = organizerDao.findAll(events.getOrganizer().getId());
			for (Organizer organizer : listOrgan) {
				paragraph = new Paragraph();
				paragraph.add(new Chunk("Організатори: ",font));
				paragraph.add(new Chunk(organizer.getNameorganizer(),boltfontsmall));
				document.add(paragraph);
			}
			
			
			if(events.getDoctor()!=null){
				listDoctor = doctorDao.findAll(events.getDoctor().getId());
			for (Doctor doctor : listDoctor) {
				
				listTypeDoc = typeDoctorDao.findDoc(doctor.getTypedoc().getId());
				for (TypeDoctor typeDoctor : listTypeDoc) {
					typeDoc = typeDoctor.getNametypedoctor();
				}
				
				paragraph = new Paragraph();
				paragraph.add(new Chunk("Лікар: ",font));
				paragraph.add(new Chunk(doctor.getLastnamedoc()+" "+doctor.getFirstnamedoc()+" ("+typeDoc+")",boltfontsmall));
				document.add(paragraph);
			
				paragraph = new Paragraph();
				paragraph.add(new Chunk(TAB+TAB+"Спеціальність: ",font));
				paragraph.add(new Chunk(doctor.getSpecialtydoc(),boltfontsmall));
				document.add(paragraph);
				
				paragraph = new Paragraph();
				paragraph.add(new Chunk(TAB+TAB+" моб.тел.: ",font));
				paragraph.add(new Chunk(doctor.getCellnumbdoc()+",",boltfontsmall));
				document.add(paragraph);
				
				paragraph = new Paragraph();
				paragraph.add(new Chunk(TAB+TAB+" e-mail: ",font));
				paragraph.add(new Chunk(doctor.getEmaildoc()+",",boltfontsmall));
				document.add(paragraph);
				}
			} else {
				paragraph = new Paragraph();
				paragraph.add(new Chunk("Лікар: ",font));
				paragraph.add(new Chunk("лікарня немає",boltfontsmall));
				document.add(paragraph);
			}
			paragraph = new Paragraph();
			paragraph.add(new Chunk("Програма: ",font));
			paragraph.add(new Chunk(events.getProgram(),boltfontsmall));
			document.add(paragraph);
			
			paragraph = new Paragraph();
			paragraph.add(new Chunk("Мета: ",font));
			paragraph.add(new Chunk(events.getPurpose(),boltfontsmall));
			document.add(paragraph);
			
			paragraph = new Paragraph();
			paragraph.add(new Chunk("Актуальність: ",font));
			paragraph.add(new Chunk(events.getTopicality(),boltfontsmall));
			document.add(paragraph);
			
			paragraph = new Paragraph();
			paragraph.add(new Chunk("Очікувані результати: ",font));
			paragraph.add(new Chunk(events.getExpectresult(),boltfontsmall));
			document.add(paragraph);
			
			paragraph = new Paragraph();
			paragraph.add(new Chunk("Інша інформація: ",font));
			paragraph.add(new Chunk(events.getOtherinfo(),boltfontsmall));
			document.add(paragraph);
			
			paragraph = new Paragraph();
			paragraph.add(new Chunk("Сума вкладки: ",font));
			paragraph.add(new Chunk(events.getSumparticip().toString()+"грн.",boltfontsmall));
			document.add(paragraph);
			
			paragraph = new Paragraph("Кошторис витрат",boltfont);
			paragraph.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph);
			
			paragraph = new Paragraph("  ",boltfont);
			paragraph.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph);
			
		
			
			table = new PdfPTable(6); // 6 columns.
			float[] columnWidths = {2f, 1f, 1f,1f,1f,1f};
			table.setWidths(columnWidths);
			table.addCell(new PdfPCell(new Paragraph("Кошторис витрат",boltfontsmall)));
            table.addCell(new PdfPCell(new Paragraph("Вкладка",boltfontsmall)));
            table.addCell(new PdfPCell(new Paragraph("КПС",boltfontsmall)));
            table.addCell(new PdfPCell(new Paragraph("Бюджет",boltfontsmall)));
            table.addCell(new PdfPCell(new Paragraph("Спонсор",boltfontsmall)));
            table.addCell(new PdfPCell(new Paragraph("Інше",boltfontsmall)));
            document.add(table);
            
            listEstimate = estimateDao.findEstimate(events.getId());
            
            for (Estimate estimate : listEstimate) {
            	table = new PdfPTable(6);
    			table.setWidths(columnWidths);
            	listCostitem = costitemDao.findAll(estimate.getCostitem().getId());
            	for (Costitem costitem : listCostitem) {
					costName = costitem.getNamecostitem();
				}
            	
            	table.addCell(new PdfPCell(new Paragraph(costName,font)));
                table.addCell(new PdfPCell(new Paragraph(estimate.getSumparticipant().toString(),font)));
                table.addCell(new PdfPCell(new Paragraph(estimate.getSumplast().toString(),font)));
                table.addCell(new PdfPCell(new Paragraph(estimate.getSumbudget().toString(),font)));
                table.addCell(new PdfPCell(new Paragraph(estimate.getSumsponsor().toString(),font)));
                table.addCell(new PdfPCell(new Paragraph(estimate.getSumother().toString(),boltfontsmall)));
                document.add(table);
			}
			
			document.close();
			System.out.println("END FILE");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.hashid = hashid;
		
		
	}

	public CreateFileAdvert() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateFileAdvert(String hashid) {
		super();
		this.hashid = hashid;
	}
	@SuppressWarnings("deprecation")
	public int countyear(Date today, Date birthday){
		int years = today.getYear() - birthday.getYear();
		int monthtoday = today.getMonth();
		int monthbirth = birthday.getMonth();
		if(monthtoday < monthbirth){
			years--;
		} else if(monthtoday == monthbirth && (today.getDate() < birthday.getDate())){
			years--;
		}
		return years;
	}
	
}
