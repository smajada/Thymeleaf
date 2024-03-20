package com.smajada.thymeleaf.demo;

import com.smajada.thymeleaf.demo.entities.Administrativo;
import com.smajada.thymeleaf.demo.entities.Comercial;
import com.smajada.thymeleaf.demo.entities.Trabajador;
import com.smajada.thymeleaf.demo.repository.TrabajadorRepository;
import com.smajada.thymeleaf.demo.service.TrabajadorServicio;
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
	TrabajadorRepository trabajadorRepository;

	@InjectMocks
	TrabajadorServicio trabajadorServicio;

	@Test
	void shouldListAllEstudiantes(){
		List<Trabajador> trabajadorList = new ArrayList<>();

		Trabajador comercial = new Comercial(1L, "Juan", "Aguilera", "jaguilera@gmail.com", 20);
		trabajadorList.add(comercial);
		trabajadorList.add(new Comercial(2L, "Begoña", "Carrillo", "bcarrillo@gmail.com", 20));
		trabajadorList.add(new Administrativo(3L, "Carmelo", "Parco", "cparco@gmail.com", "Marketing"));

		when(trabajadorRepository.findAll()).thenReturn(trabajadorList);

		List<Trabajador> response = trabajadorServicio.listAllTrabajadores();

		assertFalse(response.isEmpty());
		assertEquals(comercial, response.get(0));
	}

	@Test
	void shouldGetEstudianteById(){
		List<Trabajador> trabajadorList = new ArrayList<>();
		trabajadorList.add(new Comercial(2L, "Begoña", "Carrillo", "bcarrillo@gmail.com", 20));
		trabajadorList.add(new Administrativo(3L, "Carmelo", "Parco", "cparco@gmail.com", "Marketing"));

		when(trabajadorRepository.getReferenceById(2L)).thenReturn(trabajadorList.get(1));

		Trabajador response = trabajadorServicio.getTrabajadorporId(2L);

//		System.out.println(estudianteList);
//		System.out.println(estudianteList.get(1));
//		System.out.println(response);

        assertNotNull(response);
		assertEquals(trabajadorList.get(1), response);
	}

	@Test
	void shouldSaveEstudiante(){
		 Trabajador trabajador3 = new Administrativo(3L, "Carmelo", "Parco", "cparco@gmail.com", "Marketing");

		when(trabajadorRepository.save(trabajador3)).thenReturn(trabajador3);

		Trabajador response = trabajadorServicio.guardarTrabajadores(trabajador3);

		assertNotNull(response);
		assertEquals(trabajador3, response);
	}

	@Test
	void shouldUpdateTrabajador(){
		List<Trabajador> trabajadorList = new ArrayList<>();
		trabajadorList.add(new Comercial(2L, "Begoña", "Carrillo", "bcarrillo@gmail.com", 20));
		trabajadorList.add(new Administrativo(3L, "Carmelo", "Parco", "cparco@gmail.com", "Marketing"));

		Administrativo trabajadorUpdated = new Administrativo(3L, "Juan", "Parco", "cparco@gmail.com", "Cuentas");

		trabajadorServicio.actualizarTrabajador(trabajadorUpdated);

		verify(trabajadorRepository).save(trabajadorUpdated);
	}

	@Test
	void shouldDeleteTrabajador(){
		List<Trabajador> trabajadorList = new ArrayList<>();
		trabajadorList.add(new Comercial(2L, "Begoña", "Carrillo", "bcarrillo@gmail.com", 20));
		trabajadorList.add(new Administrativo(3L, "Carmelo", "Parco", "cparco@gmail.com", "Marketing"));

		trabajadorServicio.eliminarTrabajador(2L);

		verify(trabajadorRepository).deleteById(2L);
	}
}
