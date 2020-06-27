package com.example.demo.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aspose.cells.BackgroundType;
import com.aspose.cells.Cell;
import com.aspose.cells.Color;
import com.aspose.cells.ImportTableOptions;
import com.aspose.cells.Range;
import com.aspose.cells.SaveFormat;
import com.aspose.cells.Style;
import com.aspose.cells.TextAlignmentType;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import com.example.demo.dto.PersonDetailsCSV;
import com.example.demo.dto.PersonDetailsDTO;
import com.example.demo.entity.PersonDetails;
import com.example.demo.repository.PersonDetailsRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

/**
 * 
 * @author vamsir
 *
 */
@Service
public class PersonDetailsService {

	@Autowired
	public PersonDetailsRepository personDetailsRepository;

	public static String[] personDetatilsHeader = new String[] { "Sr No", "Person Id", "Person Name", "Person Age",
			"Phone Number", "person Email", "State", "Country", "Pin Code", "Post Office", "Door Number", "Mandal",
			"City", "Create Date", "Created By", "Active" };

	/**
	 * This method for save Person Details
	 * 
	 * @param personDetailsDTO
	 * @return
	 */
	public PersonDetailsDTO create(PersonDetailsDTO personDetailsDTO) {
		PersonDetails personDetails = new PersonDetails();
		/*
		 * // case 1: 
		 * personDetails.setPersonName(personDetailsDTO.getPersonName());
		 * personDetails.setPersonAge(personDetailsDTO.getPersonAge());
		 * personDetails.setPostOffice(personDetailsDTO.getPostOffice());
		 * personDetails.setPhoneNumber(personDetailsDTO.getPhoneNumber());
		 * personDetails.setPersonEmail(personDetailsDTO.getPersonEmail());
		 * personDetails.setPinCode(personDetailsDTO.getPinCode());
		 * personDetails.setCity(personDetailsDTO.getCity());
		 * personDetails.setCountry(personDetailsDTO.getCountry());
		 * personDetails.setCreateDate(personDetailsDTO.getCreateDate());
		 * personDetails.setState(personDetailsDTO.getState());
		 * personDetails.setDoorNumber(personDetailsDTO.getDoorNumber());
		 * personDetails.setMandal(personDetailsDTO.getMandal());
		 * personDetails.setModifiedDate(personDetailsDTO.getModifiedDate());
		 * personDetails.setCreatedBy(personDetailsDTO.getCreatedBy());
		 * personDetails.setModifiedBy(personDetailsDTO.getModifiedBy());
		 * personDetails.setActive(true);
		 * personDetails.setPersonId(personDetailsDTO.getPersonId());
		 * personDetailsRepository.save(personDetails);
		 */

		// case 2:
		BeanUtils.copyProperties(personDetailsDTO, personDetails);
		personDetailsRepository.save(personDetails);

		return personDetailsDTO;
	}

	/**
	 * This method is update Person Details
	 * 
	 * @param personDetailsDTO
	 * @return
	 */
	public PersonDetails update(PersonDetailsDTO personDetailsDTO) {
		Optional<PersonDetails> personDetails = personDetailsRepository.findById(personDetailsDTO.getPersonId());
		PersonDetails personDetailsObj = new PersonDetails();
		if (personDetails.isPresent()) {
			personDetailsObj = personDetails.get();
			/*
			 * // case 1: personDetailsObj.setPersonName(personDetailsDTO.getPersonName());
			 * personDetailsObj.setPersonAge(personDetailsDTO.getPersonAge());
			 * personDetailsObj.setPostOffice(personDetailsDTO.getPostOffice());
			 * personDetailsObj.setPhoneNumber(personDetailsDTO.getPhoneNumber());
			 * personDetailsObj.setPersonEmail(personDetailsDTO.getPersonEmail());
			 * personDetailsObj.setPinCode(personDetailsDTO.getPinCode());
			 * personDetailsObj.setCity(personDetailsDTO.getCity());
			 * personDetailsObj.setCountry(personDetailsDTO.getCountry());
			 * personDetailsObj.setState(personDetailsDTO.getState());
			 * personDetailsObj.setDoorNumber(personDetailsDTO.getDoorNumber());
			 * personDetailsObj.setMandal(personDetailsDTO.getMandal());
			 * personDetailsObj.setModifiedDate(personDetailsDTO.getModifiedDate());
			 * personDetailsObj.setModifiedBy(personDetailsDTO.getModifiedBy());
			 * personDetailsRepository.save(personDetailsObj);
			 */

			/*
			 * // case 2:
			 * personDetails.get().setPersonName(personDetailsDTO.getPersonName());
			 * personDetails.get().setPersonAge(personDetailsDTO.getPersonAge());
			 * personDetails.get().setPostOffice(personDetailsDTO.getPostOffice());
			 * personDetails.get().setPhoneNumber(personDetailsDTO.getPhoneNumber());
			 * personDetails.get().setPersonEmail(personDetailsDTO.getPersonEmail());
			 * personDetails.get().setPinCode(personDetailsDTO.getPinCode());
			 * personDetails.get().setCity(personDetailsDTO.getCity());
			 * personDetails.get().setCountry(personDetailsDTO.getCountry());
			 * personDetails.get().setCreateDate(personDetailsDTO.getCreateDate());
			 * personDetails.get().setState(personDetailsDTO.getState());
			 * personDetails.get().setDoorNumber(personDetailsDTO.getDoorNumber());
			 * personDetails.get().setMandal(personDetailsDTO.getMandal());
			 * personDetails.get().setModifiedDate(personDetailsDTO.getModifiedDate());
			 * personDetailsRepository.save(personDetails.get());
			 */

			// case 3:
			BeanUtils.copyProperties(personDetailsDTO, personDetails.get());
			personDetailsRepository.save(personDetails.get());

		}
		return personDetails.get();
	}

	/**
	 * This method is get Based on Person ID
	 * 
	 * @param id
	 * @return
	 */
	public PersonDetailsDTO getBasedOnPersonId(int id) {
		Optional<PersonDetails> personDetailsObj = personDetailsRepository.findById(id);
		PersonDetailsDTO personDetailsDTO = new PersonDetailsDTO();
		PersonDetails personDetails = new PersonDetails();
		if (personDetailsObj.isPresent()) {
			/*
			 * // case 1: 
			 * personDetails = personDetailsObj.get();
			 * personDetailsDTO.setActive(personDetails.getActive());
			 * personDetailsDTO.setCity(personDetails.getCity());
			 * personDetailsDTO.setCountry(personDetails.getCountry());
			 * personDetailsDTO.setCreateDate(personDetails.getCreateDate());
			 * personDetailsDTO.setCreatedBy(personDetails.getCreatedBy());
			 * personDetailsDTO.setDoorNumber(personDetails.getDoorNumber());
			 * personDetailsDTO.setMandal(personDetails.getMandal());
			 * personDetailsDTO.setModifiedBy(personDetails.getModifiedBy());
			 * personDetailsDTO.setModifiedDate(personDetails.getModifiedDate());
			 * personDetailsDTO.setPersonAge(personDetails.getPersonAge());
			 * personDetailsDTO.setPersonEmail(personDetails.getPersonEmail());
			 * personDetailsDTO.setPersonId(personDetails.getPersonId());
			 * personDetailsDTO.setPersonName(personDetails.getPersonName());
			 * personDetailsDTO.setPhoneNumber(personDetails.getPhoneNumber());
			 * personDetailsDTO.setPinCode(personDetails.getPinCode());
			 * personDetailsDTO.setPostOffice(personDetails.getPostOffice());
			 * personDetailsDTO.setState(personDetails.getState());
			 */
			// case 2:
			BeanUtils.copyProperties(personDetailsObj.get(), personDetailsDTO);
			return personDetailsDTO;
		}
		return personDetailsDTO;
	}

	/**
	 * This method for get all Person Details
	 * 
	 * @return
	 */
	public List<PersonDetailsDTO> getAllPersonDetails() {
		List<PersonDetails> personDetails = personDetailsRepository.findAll();
		List<PersonDetailsDTO> listOfPesonDetails = new ArrayList<>();
		/*
		 * // case 1: 
		 * for (PersonDetails person : personDetails) { 
		 * PersonDetailsDTO
		 * personDetailsDTO = new PersonDetailsDTO();
		 * personDetailsDTO.setCity(person.getCity());
		 * personDetailsDTO.setCountry(person.getCountry());
		 * personDetailsDTO.setCreateDate(person.getCreateDate());
		 * personDetailsDTO.setCreatedBy(person.getCreatedBy());
		 * personDetailsDTO.setDoorNumber(person.getDoorNumber());
		 * personDetailsDTO.setPersonId(person.getPersonId());
		 * personDetailsDTO.setMandal(person.getMandal());
		 * personDetailsDTO.setModifiedDate(person.getModifiedDate());
		 * personDetailsDTO.setModifiedBy(person.getModifiedBy());
		 * personDetailsDTO.setPersonAge(person.getPersonAge());
		 * personDetailsDTO.setPersonEmail(person.getPersonEmail());
		 * personDetailsDTO.setPersonName(person.getPersonName());
		 * personDetailsDTO.setPhoneNumber(person.getPhoneNumber());
		 * personDetailsDTO.setPinCode(person.getPinCode());
		 * personDetailsDTO.setPostOffice(person.getPostOffice());
		 * personDetailsDTO.setState(person.getState());
		 * personDetailsDTO.setActive(person.getActive());
		 * listOfPesonDetails.add(personDetailsDTO); }
		 */
		// case 2:
		for (PersonDetails person : personDetails) {
			PersonDetailsDTO personDetailsDTO = new PersonDetailsDTO();
			BeanUtils.copyProperties(person, personDetailsDTO);
			listOfPesonDetails.add(personDetailsDTO);
		}
		return listOfPesonDetails;
	}

	/**
	 * This method is delete person details based on id
	 * 
	 * @param id
	 * @return
	 */
	public void delete(int id) {
		Optional<PersonDetails> personDetailsObj = personDetailsRepository.findById(id);
		if (personDetailsObj.isPresent()) {
			personDetailsRepository.deleteById(personDetailsObj.get().getPersonId());
		} else {
			System.out.println("PERSON DETAILS ID IS NOT FOUND " + id);
		}
	}

	/**
	 * This method is uploaded csv file
	 * 
	 * @param file
	 * @throws IOException
	 * @throws ParseException
	 */
	public void csvFile(MultipartFile file) throws IOException, ParseException {

		File convFile = new File(file.getOriginalFilename());
		/*
		 * FileOutputStream fos = new FileOutputStream(convFile);
		 * fos.write(file.getBytes()); fos.close();
		 */
		// reading csv file
		Reader reader = new FileReader(convFile);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		CsvToBean<PersonDetailsCSV> csvToBean = new CsvToBeanBuilder(reader).withType(PersonDetailsCSV.class)
				.withIgnoreLeadingWhiteSpace(true).build();
		Iterator<PersonDetailsCSV> personCsv = csvToBean.iterator();
		PersonDetails person = new PersonDetails();
		while (personCsv.hasNext()) {
			PersonDetailsCSV personRow = personCsv.next();
			BeanUtils.copyProperties(personRow, person);
			Date createDate = new SimpleDateFormat("DD-MM-YYYY").parse(personRow.getCreateDate());
			person.setCreateDate(createDate);
			person.setActive(true);
			personDetailsRepository.save(person);
		}
	}

	/**
	 * 
	 * @param person
	 * @return 
	 * @throws Exception
	 */
	@Async
	public ByteArrayInputStream setExcelDownloadFile(List<PersonDetailsDTO> persons) throws Exception {
		//create a new workbook
		Workbook workbook = new Workbook();
		//create a new workbook sheet 1
		Worksheet worksheet = workbook.getWorksheets().get(0);
		worksheet.setName("Person Details Report");
		//Set Excel Headers row and column
		worksheet.getCells().importArray(personDetatilsHeader, 1, 0, false);
		ImportTableOptions tableOptions = new ImportTableOptions();
		tableOptions.setConvertGridStyle(true);

		setExtractDataForPersonDetatils(persons, worksheet);
		// Style for A2 to P2 headers
		Style style1 = workbook.createStyle();
		style1.setForegroundColor(Color.fromArgb(217, 217, 217));
		style1.setPattern(BackgroundType.SOLID);
		style1.getFont().setBold(true);
		style1.setHorizontalAlignment(TextAlignmentType.CENTER);
		Range headerColorRange1 = worksheet.getCells().createRange("A2:P2");
		headerColorRange1.setStyle(style1);
		// Style for B1 headers
		Cell cellC3 = worksheet.getCells().get("B1");
		cellC3.setValue("Person Details");
		Style c3Style = cellC3.getStyle();
		c3Style.getFont().setBold(true);
		c3Style.setForegroundColor(Color.fromArgb(180, 199, 220));
		c3Style.setPattern(BackgroundType.SOLID);
		c3Style.setHorizontalAlignment(TextAlignmentType.CENTER);
		cellC3.setStyle(c3Style);
		Range heardersRange = worksheet.getCells().createRange("B1:F1");
		heardersRange.merge();
		// Style for G1 headers
		Cell cellG3 = worksheet.getCells().get("G1");
		cellG3.setValue("Address details");
		Style g3Style = cellG3.getStyle();
		g3Style.getFont().setBold(true);
		g3Style.setForegroundColor(Color.fromArgb(248, 203, 173));
		g3Style.setPattern(BackgroundType.SOLID);
		g3Style.setHorizontalAlignment(TextAlignmentType.CENTER);
		cellG3.setStyle(g3Style);
		Range heardersRange2 = worksheet.getCells().createRange("G1:M1");
		heardersRange2.merge();
		// Style for N1 headers
		Cell cellO3 = worksheet.getCells().get("N1");
		cellO3.setValue("Created Person Details");
		Style o3Style = cellO3.getStyle();
		o3Style.setForegroundColor(Color.fromArgb(255, 230, 153));
		o3Style.setPattern(BackgroundType.SOLID);
		o3Style.setHorizontalAlignment(TextAlignmentType.CENTER);
		o3Style.getFont().setBold(true);
		cellO3.setStyle(o3Style);
		Range heardersRange3 = worksheet.getCells().createRange("N1:P1");
		heardersRange3.merge();
		// Auto Fit Columns and Rows
		worksheet.autoFitColumns();
		worksheet.autoFitRows();
		// Write the output to the file
		ByteArrayOutputStream baout = new ByteArrayOutputStream();
		workbook.save(baout, SaveFormat.XLSX);
	    return new ByteArrayInputStream(baout.toByteArray());
	}

	private void setExtractDataForPersonDetatils(List<PersonDetailsDTO> persons, Worksheet worksheet) throws Exception {
		if (!persons.isEmpty()) {
			//Data Print row
			int rowIndex = 2;
			Integer serialNumber = 1;
			for (PersonDetailsDTO person : persons) {
				ArrayList<Object> rowData = new ArrayList<Object>();
				rowData.add(serialNumber.toString());
				rowData.add(String.valueOf(person.getPersonId()) == null ? StringUtils.EMPTY : person.getPersonId());
				rowData.add(person.getPersonName() == null ? StringUtils.EMPTY : person.getPersonName());
				rowData.add(String.valueOf(person.getPersonAge()) == null ? StringUtils.EMPTY : person.getPersonAge());
				rowData.add(
						String.valueOf(person.getPhoneNumber()) == null ? StringUtils.EMPTY : person.getPhoneNumber());
				rowData.add(person.getPersonEmail() == null ? StringUtils.EMPTY : person.getPersonEmail());
				rowData.add(person.getState() == null ? StringUtils.EMPTY : person.getState());
				rowData.add(person.getCountry() == null ? StringUtils.EMPTY : person.getCountry());
				rowData.add(String.valueOf(person.getPinCode()) == null ? StringUtils.EMPTY : person.getPinCode());
				rowData.add(person.getPostOffice() == null ? StringUtils.EMPTY : person.getPostOffice());
				rowData.add(person.getDoorNumber() == null ? StringUtils.EMPTY : person.getDoorNumber());
				rowData.add(person.getMandal() == null ? StringUtils.EMPTY : person.getMandal());
				rowData.add(person.getCity() == null ? StringUtils.EMPTY : person.getCity());
				rowData.add(person.getCreateDate() == null ? StringUtils.EMPTY : person.getCreateDate());
				rowData.add(person.getCreatedBy() == null ? StringUtils.EMPTY : person.getCreatedBy());
				rowData.add(person.getActive() == null ? StringUtils.EMPTY : person.getActive());

				worksheet.getCells().importArrayList(rowData, rowIndex++, 0, false);
				serialNumber++;
			}
		}
	}
}
