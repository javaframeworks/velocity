package br.com.javaframeworks.velocity;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.Template;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.MethodInvocationException;

import br.com.javaframeworks.velocity.model.Animal;

/**
 * Mecanismo básico de merge do velocity
 * @author Wagner R
 */
public class Basico {

	public static void main(String[] args) throws Exception {

		Velocity.init();

		VelocityContext context = new VelocityContext();

		context.put("nome", "André Castro");

		List<Animal> animais = new ArrayList<Animal>();
		animais.add(new Animal("Pastor Alemão", 100.0));
		animais.add(new Animal("Rã", 3.0));
		context.put("animais", animais);


		Template template = null;

		try {
			template = Velocity.getTemplate("src/main/resources/templates/exemplo.vm","UTF-8");
		} catch (ResourceNotFoundException rnfe) {
			// couldn't find the template
		} catch (ParseErrorException pee) {
			// syntax error: problem parsing the template
		} catch (MethodInvocationException mie) {
			// something invoked in the template
			// threw an exception
		} catch (Exception e) {
		}

		StringWriter sw = new StringWriter();

		template.merge(context, sw);
		
		System.out.println(sw);

	}
}
