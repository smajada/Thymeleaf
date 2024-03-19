package com.smajada.thymeleaf.demo;

import com.smajada.thymeleaf.demo.entities.Estudiante;
import com.smajada.thymeleaf.demo.repository.EstudianteRepository;
import com.smajada.thymeleaf.demo.service.EstudianteServicio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class DemoApplicationTests {

	@Mock
	EstudianteRepository estudianteRepository;

	@InjectMocks
	EstudianteServicio estudianteServicio;

	@Test
	void shouldListAllEstudiantes(){
		List<Estudiante> estudianteList = new ArrayList<>();

		Estudiante estudiante1 = new Estudiante(1L, "Juan", "Aguilera", "jaguilera@gmail.com");
		estudianteList.add(estudiante1);
		estudianteList.add(new Estudiante(2L, "Begoña", "Carrillo", "bcarrillo@gmail.com"));
		estudianteList.add(new Estudiante(3L, "Carmelo", "Parco", "cparco@gmail.com"));

		when(estudianteRepository.findAll()).thenReturn(estudianteList);

		List<Estudiante> response = estudianteServicio.listAllEstudiantes();

		assertFalse(response.isEmpty());
		assertEquals(estudiante1, response.get(0));
	}

	@Test
	void shouldGetEstudianteById(){
		List<Estudiante> estudianteList = new ArrayList<>();
		estudianteList.add(new Estudiante(1L, "Begoña", "Carrillo", "bcarrillo@gmail.com"));
		estudianteList.add(new Estudiante(2L, "Carmelo", "Parco", "cparco@gmail.com"));

		when(estudianteRepository.getReferenceById(2L)).thenReturn(estudianteList.get(1));

		Estudiante response = estudianteServicio.getEstudianteporId(2L);

//		System.out.println(estudianteList);
//		System.out.println(estudianteList.get(1));
//		System.out.println(response);

        assertNotNull(response);
		assertEquals(estudianteList.get(1), response);
	}

	@Test
	void shouldSaveEstudiante(){
		 Estudiante estudiante3 = new Estudiante(3L, "Juan", "Aguilera", "jaguilera@gmail.com");

		when(estudianteRepository.save(estudiante3)).thenReturn(estudiante3);

		Estudiante response = estudianteServicio.guardarEstudiante(estudiante3);

		assertNotNull(response);
		assertEquals(estudiante3, response);
	}

	@Test
	void shouldUpdateEstudiante(){
		List<Estudiante> estudianteList = new ArrayList<>();
		estudianteList.add(new Estudiante(1L, "Begoña", "Carrillo", "bcarrillo@gmail.com"));
		estudianteList.add(new Estudiante(2L, "Carmelo", "Parco", "cparco@gmail.com"));

		Estudiante estudianteUpdated = new Estudiante(1L, "Juan", "Aguilera", "jaguilera@gmail.com");

		estudianteServicio.actualizarEstudiante(estudianteUpdated);

		verify(estudianteRepository).save(estudianteUpdated);
	}

	@Test
	void shouldDeleteEstudiante(){
		List<Estudiante> estudianteList = new ArrayList<>();
		estudianteList.add(new Estudiante(1L, "Begoña", "Carrillo", "bcarrillo@gmail.com"));
		estudianteList.add(new Estudiante(2L, "Carmelo", "Parco", "cparco@gmail.com"));

		estudianteServicio.eliminarEstudiante(1L);

		verify(estudianteRepository).deleteById(1L);
	}
}
