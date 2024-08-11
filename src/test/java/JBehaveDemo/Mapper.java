package JBehaveDemo;

import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

public class Mapper extends JUnitStory {
	
	@Override
    public Configuration configuration() {
		System.out.println("Config");
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                .useStoryControls(new StoryControls().doResetStateBeforeScenario(false))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withCodeLocation(CodeLocations.codeLocationFromClass(this.getClass()))
                        .withFormats(Format.CONSOLE, Format.TXT, Format.HTML, Format.XML));
    }
	
	@Override
	 public List<String> storyPaths() {
		System.out.println("Paths");
	        return new StoryFinder().findPaths("src/test/resources","**/MyStories.story", "");
	 }
	
	@Override
    public InjectableStepsFactory stepsFactory() {
		System.out.println("Steps");
        return new InstanceStepsFactory(configuration(), new Steps());
    }
}
