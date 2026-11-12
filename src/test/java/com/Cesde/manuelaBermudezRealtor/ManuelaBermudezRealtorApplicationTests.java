package com.Cesde.manuelaBermudezRealtor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.Cesde.manuelaBermudezRealtor.modelo.MAdmin;
import com.Cesde.manuelaBermudezRealtor.repositories.IAdmin;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = {
		"spring.datasource.url=jdbc:h2:mem:realtor;DB_CLOSE_DELAY=-1",
		"spring.datasource.driver-class-name=org.h2.Driver",
		"spring.datasource.username=sa",
		"spring.datasource.password=",
		"spring.jpa.hibernate.ddl-auto=create-drop"
})
class ManuelaBermudezRealtorApplicationTests {
	@Autowired
	private IAdmin adminRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void adminPersistsInheritedUserFields() {
		MAdmin admin = new MAdmin();
		admin.setNombre("Ana");
		admin.setApellido("Lopez");
		admin.setPassword("test-password");
		admin.setTelefono("3001234567");
		admin.setCorreo("ana@example.com");
		admin.setAdminType("GESTION");

		MAdmin saved = adminRepository.save(admin);
		MAdmin loaded = adminRepository.findById(saved.getId()).orElseThrow();

		assertEquals("Ana", loaded.getNombre());
		assertEquals("Lopez", loaded.getApellido());
		assertEquals("GESTION", loaded.getAdminType());
		adminRepository.delete(loaded);
	}

}
