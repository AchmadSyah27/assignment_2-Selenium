package jakartalabs.assignment2;

public class AppEnums {

	public enum MenuNames {

		SIGNIN("Sign In"), BLOG("Blog"), userProfile("userProfile"), dashboard("mydashBoard ng-star-inserted");

		private String filter;

		private MenuNames(String filter) {
			this.filter = filter;
		}

		@Override
		public String toString() {
			return filter;

		}

	}

	public enum ButtonNames {

		chooseABase("Choose a base"), signIn("Sign In"), chooseTemplate("Sign In"), closeButton("closeButton"),
		iconCancel("icon-cancel"), natashaMsgPanel("natashaMsgPanel"), buildNow("getStart"), planDelivery("nextButton"),
		wizardDot("wizardDot"), done("Done"), save("Save"), startProject("Start Project");

		private String filter;

		private ButtonNames(String filter) {
			this.filter = filter;
		}

		@Override
		public String toString() {
			return filter;

		}

	}

}
