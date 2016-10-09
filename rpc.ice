// Printer.ice
module javafxbrowser{
module rpc{
	["java:serializable:javafxbrowser.cfg.BrowserConfigurator"]
	sequence<byte> ConfigObj;
	
    interface InterComm {
        //
        // A client can invoke this operation on a server.
        // In this example we print the string s
        //
        void printString(string s);
		ConfigObj getConfig();
		void setConfig(ConfigObj conf);
    };
	interface ClientWP{
		void updateConfig(ConfigObj conf);
	};
	};
};