package com.example.demo.resource;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.common.ApiStatus;
import com.example.demo.dto.PersonDetailsDTO;
import com.example.demo.entity.PersonDetails;
import com.example.demo.service.PersonDetailsService;


/**
 * 
 * @author vamsir
 *
 */

@RestController
@RequestMapping("/person")
public class PersonDetailsResource {

	@Autowired
	public PersonDetailsService personDetailsService;

	/**
	 * This API for Create Person Details
	 * 
	 * @param personDetailsDTO
	 * @return
	 */
	@PostMapping("/create")
	public ResponseEntity<ApiStatus<PersonDetailsDTO>> createPersonDetails(@RequestBody PersonDetailsDTO personDetailsDTO) {
		PersonDetailsDTO person = personDetailsService.create(personDetailsDTO);
		ApiStatus<PersonDetailsDTO> apiStatus = new ApiStatus<>(HttpStatus.CREATED, "SUCCESS",
				"PERSON DETAILS CREATED SUCCESSFLLY", person);
		return new ResponseEntity<ApiStatus<PersonDetailsDTO>>(apiStatus, HttpStatus.CREATED);
	}

	/**
	 * This API for Update Person Details
	 * 
	 * @param personDetailsDTO
	 * @return
	 */
	@PutMapping("/update")
	public ResponseEntity<ApiStatus<PersonDetails>> updatePersonDetails(@RequestBody PersonDetailsDTO personDetailsDTO) {
		PersonDetails person = personDetailsService.update(personDetailsDTO);
		ApiStatus<PersonDetails> apiStatus = new ApiStatus<>(HttpStatus.UPGRADE_REQUIRED, "SUCCESS",
				"PERSON DETAILS UPDATED SUCCESSFLLY", person);
		return new ResponseEntity<ApiStatus<PersonDetails>>(apiStatus, HttpStatus.UPGRADE_REQUIRED);
	}

	/**
	 * This API for get Based on Person ID
	 * 
	 * @param personDetailsDTO
	 * @param id
	 * @return
	 */
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<ApiStatus<PersonDetailsDTO>> getBasedOnPersonId(@PathVariable(name = "id", required = true) int id) {
		PersonDetailsDTO person = personDetailsService.getBasedOnPersonId(id);
		ApiStatus<PersonDetailsDTO> apiStatus = new ApiStatus<>(HttpStatus.OK, "SUCCESS",
				"GET BASED ON ID PERSON DETAILS SUCCESSFLLY", person);
		return new ResponseEntity<ApiStatus<PersonDetailsDTO>>(apiStatus, HttpStatus.OK);
	}

	/**
	 * This API for get All Person Details
	 * 
	 * @return
	 */
	@GetMapping("/getall")
	public ResponseEntity<ApiStatus<List<PersonDetailsDTO>>> getAllPesonDetails() {
		List<PersonDetailsDTO> person = personDetailsService.getAllPersonDetails();
		ApiStatus<List<PersonDetailsDTO>> apiStatus = new ApiStatus<>(HttpStatus.OK, "SUCCESS",
				"GET ALL PERSON DETAILS SUCCESSFLLY", person);
		return new ResponseEntity<ApiStatus<List<PersonDetailsDTO>>>(apiStatus, HttpStatus.OK);
	}

	/**
	 * This API for deleted Person Details
	 * 
	 * @param personDetailsDTO
	 * @return
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiStatus<?>> deletePersonDetails(@PathVariable(name = "id", required = true) int id) {
		personDetailsService.delete(id);
		ApiStatus<?> apiStatus = new ApiStatus<>(HttpStatus.OK, "SUCCESS", "PERSON DETAILS DELETED SUCCESSFLLY");
		return new ResponseEntity<ApiStatus<?>>(apiStatus, HttpStatus.OK);
	}
	/**
	 * This API for Upload CSV File
	 * @param file
	 * @return
	 * @throws ParseException 
	 * @throws IOException 
	 */
	@SuppressWarnings("unused")
	@PostMapping("/csv")
	public ResponseEntity<ApiStatus<String>> csvFileUpload(@RequestParam("file") MultipartFile file) throws IOException, ParseException {
		if (file.isEmpty() && file == null) {
			throw new FileNotFoundException("Please select the file");
		} else if (!FilenameUtils.getExtension(file.getOriginalFilename()).equalsIgnoreCase("csv")) {
			throw new FileNotFoundException("Cannot upload this file (" + file.getOriginalFilename()
					+ ") as this type of file is not accepted");
		} else {
			String csvContentType = "text/csv";
			String contentType = new Tika().detect(file.getInputStream());
			if (!csvContentType.equals(contentType)) {
				throw new FileNotFoundException("Invalid file contents, only csv files are allowed");
			}else {
				personDetailsService.csvFile(file);
			}
		}
		ApiStatus<String> apiStatus = new ApiStatus<>(HttpStatus.OK, "SUCCESS", "CSV FILE UPLOADED SUCCESSFLLY");
		return new ResponseEntity<ApiStatus<String>>(apiStatus, HttpStatus.OK);
	}
	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	@GetMapping("/download/excel")
	public ResponseEntity<InputStreamResource> writeExcelFlle() throws Exception {
		List<PersonDetailsDTO> persons = personDetailsService.getAllPersonDetails();
		ByteArrayInputStream inputStream = personDetailsService.setExcelDownloadFile(persons);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=person.xlsx");
		ApiStatus<List<PersonDetailsDTO>> apiStatus = new ApiStatus<>(HttpStatus.OK, "SUCCESS",
				"EXCEL FILE DOWNLOAD SUCCESSFULLY");
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(inputStream));
	}

}
