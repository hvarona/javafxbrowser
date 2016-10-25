/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxbrowser.manager;

import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafxbrowser.rpc.Boolean;
import javafxbrowser.rpc.ByteArray;
import javafxbrowser.rpc.ByteArrayOffset;
import javafxbrowser.rpc.FieldInt;
import javafxbrowser.rpc.FieldLong;
import javafxbrowser.rpc.ID;
import javafxbrowser.rpc.Int;
import javafxbrowser.rpc.StringObject;
import sun.net.www.protocol.http.Handler;
import javafxbrowser.rpc.URLPetitionGrpc;
import javafxbrowser.rpc.Void;
import sun.net.www.protocol.http.HttpURLConnection;

/**
 *
 * @author hvarona
 */
public class RPCURLConnection extends URLPetitionGrpc.URLPetitionImplBase {

    Map<Long, URLConnection> connections = new HashMap();
    Map<Long, InputStream> streams = new HashMap();

    public RPCURLConnection() {
    }

    @Override
    public void constructor(StringObject request, StreamObserver<ID> responseObserver) {

        Long generatedId = (long) (Math.random() * Long.MAX_VALUE);
        while (connections.containsKey(generatedId)) {
            generatedId = (long) (Math.random() * Long.MAX_VALUE);
        }

        try {
            connections.put(generatedId, new URL(request.getValue()).openConnection());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        responseObserver.onNext(javafxbrowser.rpc.ID.newBuilder().setConId(generatedId).build());
        responseObserver.onCompleted();

    }

    @Override
    public void setDefaultUseCaches(Boolean request, StreamObserver<Void> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            connections.get(id).setDefaultUseCaches(request.getValue());
            responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(id).build());
            responseObserver.onCompleted();
        }
        super.setDefaultUseCaches(request, responseObserver); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getDefaultUseCaches(Void request, StreamObserver<Boolean> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.Boolean.newBuilder().setConId(id).setValue(connections.get(id).getDefaultUseCaches()).build());
            responseObserver.onCompleted();
        }
        super.getDefaultUseCaches(request, responseObserver);
    }

    @Override
    public void getIfModifiedSince(Void request, StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(id).setValue(connections.get(id).getIfModifiedSince()).build());
            responseObserver.onCompleted();
        }
        super.getIfModifiedSince(request, responseObserver);
    }

    @Override
    public void setIfModifiedSince(javafxbrowser.rpc.Long request, StreamObserver<Void> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            connections.get(id).setIfModifiedSince(request.getValue());
            responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(id).build());
            responseObserver.onCompleted();
        }
        super.setIfModifiedSince(request, responseObserver); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getUseCaches(Void request, StreamObserver<Boolean> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.Boolean.newBuilder().setConId(id).setValue(connections.get(id).getUseCaches()).build());
            responseObserver.onCompleted();
        }
        super.getUseCaches(request, responseObserver);
    }

    @Override
    public void setUseCaches(Boolean request, StreamObserver<Void> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            connections.get(id).setUseCaches(request.getValue());
            responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(id).build());
            responseObserver.onCompleted();
        }
        super.setUseCaches(request, responseObserver); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getAllowUserInteraction(Void request, StreamObserver<Boolean> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.Boolean.newBuilder().setConId(id).setValue(connections.get(id).getAllowUserInteraction()).build());
            responseObserver.onCompleted();
        }
        super.getAllowUserInteraction(request, responseObserver);
    }

    @Override
    public void setAllowUserInteraction(Boolean request, StreamObserver<Void> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            connections.get(id).setAllowUserInteraction(request.getValue());
            responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(id).build());
            responseObserver.onCompleted();
        }
        super.setAllowUserInteraction(request, responseObserver); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getDoOutput(Void request, StreamObserver<Boolean> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.Boolean.newBuilder().setConId(id).setValue(connections.get(id).getDoOutput()).build());
            responseObserver.onCompleted();
        }
        super.getDoOutput(request, responseObserver);
    }

    @Override
    public void setDoOutput(Boolean request, StreamObserver<Void> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            connections.get(id).setDoOutput(request.getValue());
            responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(id).build());
            responseObserver.onCompleted();
        }
        super.setDoOutput(request, responseObserver); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getDoInput(Void request, StreamObserver<Boolean> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.Boolean.newBuilder().setConId(id).setValue(connections.get(id).getDoInput()).build());
            responseObserver.onCompleted();
        }
        super.getDoInput(request, responseObserver);
    }

    @Override
    public void setDoInput(Boolean request, StreamObserver<Void> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            connections.get(id).setDoInput(request.getValue());
            responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(id).build());
            responseObserver.onCompleted();
        }
        super.setDoInput(request, responseObserver); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void toStringObject(Void request, StreamObserver<StringObject> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.StringObject.newBuilder().setConId(id).setValue(connections.get(id).toString()).build());
            responseObserver.onCompleted();
        }
        super.toStringObject(request, responseObserver);
    }

    @Override
    public void getHeaderFieldLong(FieldLong request, StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(id).setValue(connections.get(id).getHeaderFieldLong(request.getName(), request.getDefault())).build());
            responseObserver.onCompleted();
        }
        super.getHeaderFieldLong(request, responseObserver);
    }

    @Override
    public void getHeaderFieldInt(FieldInt request, StreamObserver<Int> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.Int.newBuilder().setConId(id).setValue(connections.get(id).getHeaderFieldInt(request.getName(), request.getDefault())).build());
            responseObserver.onCompleted();
        }
        super.getHeaderFieldInt(request, responseObserver);
    }

    @Override
    public void getLastModified(Void request, StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(id).setValue(connections.get(id).getLastModified()).build());
            responseObserver.onCompleted();
        }
        super.getLastModified(request, responseObserver);
    }

    @Override
    public void getDate(Void request, StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(id).setValue(connections.get(id).getDate()).build());
            responseObserver.onCompleted();
        }
        super.getDate(request, responseObserver);
    }

    @Override
    public void getExpiration(Void request, StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(id).setValue(connections.get(id).getExpiration()).build());
            responseObserver.onCompleted();
        }
        super.getExpiration(request, responseObserver);
    }

    @Override
    public void getContentEncoding(Void request, StreamObserver<StringObject> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.StringObject.newBuilder().setConId(id).setValue(connections.get(id).getContentEncoding()).build());
            responseObserver.onCompleted();
        }
        super.getContentEncoding(request, responseObserver);
    }

    @Override
    public void getContentType(Void request, StreamObserver<StringObject> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.StringObject.newBuilder().setConId(id).setValue(connections.get(id).getContentType()).build());
            responseObserver.onCompleted();
        }
        super.getContentType(request, responseObserver);
    }

    @Override
    public void getContentLengthLong(Void request, StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(id).setValue(connections.get(id).getContentLengthLong()).build());
            responseObserver.onCompleted();
        }
        super.getContentLengthLong(request, responseObserver);
    }

    @Override
    public void getContentLength(Void request, StreamObserver<javafxbrowser.rpc.Int> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.Int.newBuilder().setConId(id).setValue(connections.get(id).getContentLength()).build());
            responseObserver.onCompleted();
        }
        super.getContentLength(request, responseObserver);
    }

    @Override
    public void connect(Void request, StreamObserver<Void> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            try {
                connections.get(id).connect();
                responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(id).build());
                responseObserver.onCompleted();
            } catch (IOException ex) {
                ex.printStackTrace();
                //TODO handle exceptions
            }
        }
        super.connect(request, responseObserver); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getInputStream(Void request, StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
        long idCon = request.getConId();
        if (connections.containsKey(idCon)) {
            Long generatedId = (long) (Math.random() * Long.MAX_VALUE);
            while (streams.containsKey(generatedId)) {
                generatedId = (long) (Math.random() * Long.MAX_VALUE);
            }
            System.out.println("stream di " + generatedId);
            try {
                streams.put(generatedId, connections.get(idCon).getInputStream());
                responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(idCon).setValue(generatedId).build());
                responseObserver.onCompleted();
            } catch (IOException ex) {
                Logger.getLogger(RPCURLConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            super.getInputStream(request, responseObserver); //To change body of generated methods, choose Tools | Templates.
        }
    }

    /*@Override
     public Object getContent(Class[] classes) throws IOException {
     System.out.println("14");
     return super.getContent(classes); //To change body of generated methods, choose Tools | Templates.
     }*/
    /*@Override
     public Object getContent() throws IOException {
     System.out.println("15");
     return super.getContent(); //To change body of generated methods, choose Tools | Templates.
     }*/
    /*@Override
     public URL getURL() {
     System.out.println("25");
     return super.getURL(); //To change body of generated methods, choose Tools | Templates.
     }*/
    @Override
    public void inputStreamMarkSupported(Void request, StreamObserver<Boolean> responseObserver) {
        Long id = request.getConId();
        if (streams.containsKey(id)) {
            responseObserver.onNext(Boolean.newBuilder().setConId(id).setValue(streams.get(id).markSupported()).build());
            responseObserver.onCompleted();

        }
    }

    @Override
    public void inputStreamReset(Void request, StreamObserver<Void> responseObserver) {
        Long id = request.getConId();
        if (streams.containsKey(id)) {
            try {
                streams.get(id).reset();
                responseObserver.onNext(Void.newBuilder().setConId(id).build());
                responseObserver.onCompleted();
            } catch (IOException ex) {
                //TODO catch error
                ex.printStackTrace();
            }
        }
        //super.inputStreamReset(request, responseObserver); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inputStreamMark(Int request, StreamObserver<Void> responseObserver) {
        Long id = request.getConId();
        if (streams.containsKey(id)) {
            streams.get(id).mark(request.getValue());
            responseObserver.onNext(Void.newBuilder().setConId(id).build());
            responseObserver.onCompleted();
        }
        //super.inputStreamMark(request, responseObserver); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inputStreamAvailable(Void request, StreamObserver<Int> responseObserver) {
        Long id = request.getConId();
        if (streams.containsKey(id)) {
            try {
                responseObserver.onNext(Int.newBuilder().setConId(id).setValue(streams.get(id).available()).build());
                responseObserver.onCompleted();
            } catch (IOException ex) {
                //TODO catch error
                ex.printStackTrace();
            }
        }
        //super.inputStreamAvailable(request, responseObserver); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inputStreamSkip(javafxbrowser.rpc.Long request, StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
        Long id = request.getConId();
        if (streams.containsKey(id)) {
            try {
                responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(id).setValue(streams.get(id).skip(request.getValue())).build());
                responseObserver.onCompleted();
            } catch (IOException ex) {
                //TODO catch error
                ex.printStackTrace();
            }
        }
        //super.inputStreamSkip(request, responseObserver); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inputStreamReadArrayOff(ByteArrayOffset request, StreamObserver<Int> responseObserver) {
        Long id = request.getConId();
        if (streams.containsKey(id)) {
            try {
                responseObserver.onNext(Int.newBuilder().setConId(id).setValue(streams.get(id).read(request.getArray().toByteArray(), request.getOffset(), request.getLen())).build());
                responseObserver.onCompleted();
            } catch (IOException ex) {
                //TODO catch error
                ex.printStackTrace();
            }
        }
        //super.inputStreamReadArrayOff(request, responseObserver); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inputStreamReadArray(ByteArray request, StreamObserver<Int> responseObserver) {
        Long id = request.getConId();
        if (streams.containsKey(id)) {
            try {
                responseObserver.onNext(Int.newBuilder().setConId(id).setValue(streams.get(id).read(request.getArray().toByteArray())).build());
                responseObserver.onCompleted();
            } catch (IOException ex) {
                //TODO catch error
                ex.printStackTrace();
            }
        }
        //super.inputStreamReadArray(request, responseObserver); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inputStreamRead(Void request, StreamObserver<Int> responseObserver) {
        Long id = request.getConId();
        if (streams.containsKey(id)) {
            try {
                responseObserver.onNext(Int.newBuilder().setConId(id).setValue(streams.get(id).read()).build());
                responseObserver.onCompleted();
            } catch (IOException ex) {
                //TODO catch error
                ex.printStackTrace();
            }
        }
        //super.inputStreamRead(request, responseObserver); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inputStreamClose(Void request, StreamObserver<Void> responseObserver) {
        Long id = request.getConId();
        System.out.println("InpuStreamClose");
        if (streams.containsKey(id)) {
            try {
                streams.get(id).close();

            } catch (IOException ex) {
                //TODO catch error
                ex.printStackTrace();
            }
            responseObserver.onNext(Void.newBuilder().setConId(id).build());
            responseObserver.onCompleted();
        } else {
            System.out.println("Bad ID " + id);
        }
        System.out.println("Stream closed");
        //super.inputStreamClose(request, responseObserver);
    }
}
