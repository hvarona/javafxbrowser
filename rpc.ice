// Printer.ice
module javafxbrowser{
module rpc{
	class config{
		string homepage;
		string defaultDownloadDirectory;
	};
    interface InterComm {
        //
        // A client can invoke this operation on a server.
        // In this example we print the string s
        //
        void printString(string s);
		config getConfig();
		void setConfig(config conf);
    };
	};
};