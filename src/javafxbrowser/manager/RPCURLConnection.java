package javafxbrowser.manager;

import com.google.protobuf.ByteString;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
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
import javafxbrowser.rpc.StreamRead;
import javafxbrowser.rpc.StringObject;
import javafxbrowser.rpc.URLPetitionGrpc;
import javafxbrowser.rpc.Void;
import sun.net.www.protocol.http.HttpURLConnection;

/**
 *
 * @author hvarona
 */
public class RPCURLConnection extends URLPetitionGrpc.URLPetitionImplBase {

    Map<Long, URLConnection> connections = new HashMap();
    Map<Long, InputStream> inputStreams = new HashMap();
    Map<Long, OutputStream> outputStreams = new HashMap();

    public RPCURLConnection() {
    }

    @Override
    public void constructor(StringObject request, StreamObserver<ID> responseObserver) {

        long generatedId = (long) (Math.random() * Long.MAX_VALUE);
        while (connections.containsKey(generatedId)) {
            generatedId = (long) (Math.random() * Long.MAX_VALUE);
        }

        try {
            //connections.put(generatedId, new URL(request.getValue()).openConnection());
            connections.put(generatedId, new HttpURLConnection(new URL(request.getValue()), Proxy.NO_PROXY));
        } catch (IOException ex) {
            ex.printStackTrace();
            generatedId = -1;
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
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getDefaultUseCaches(Void request, StreamObserver<Boolean> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.Boolean.newBuilder().setConId(id).setValue(connections.get(id).getDefaultUseCaches()).build());
            responseObserver.onCompleted();
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Boolean.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getIfModifiedSince(Void request, StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(id).setValue(connections.get(id).getIfModifiedSince()).build());
            responseObserver.onCompleted();
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void setIfModifiedSince(javafxbrowser.rpc.Long request, StreamObserver<Void> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            connections.get(id).setIfModifiedSince(request.getValue());
            responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(id).build());
            responseObserver.onCompleted();
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getUseCaches(Void request, StreamObserver<Boolean> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.Boolean.newBuilder().setConId(id).setValue(connections.get(id).getUseCaches()).build());
            responseObserver.onCompleted();
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Boolean.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void setUseCaches(Boolean request, StreamObserver<Void> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            connections.get(id).setUseCaches(request.getValue());
            responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(id).build());
            responseObserver.onCompleted();
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getAllowUserInteraction(Void request, StreamObserver<Boolean> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.Boolean.newBuilder().setConId(id).setValue(connections.get(id).getAllowUserInteraction()).build());
            responseObserver.onCompleted();
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Boolean.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void setAllowUserInteraction(Boolean request, StreamObserver<Void> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            connections.get(id).setAllowUserInteraction(request.getValue());
            responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(id).build());
            responseObserver.onCompleted();
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getDoOutput(Void request, StreamObserver<Boolean> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.Boolean.newBuilder().setConId(id).setValue(connections.get(id).getDoOutput()).build());
            responseObserver.onCompleted();
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Boolean.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void setDoOutput(Boolean request, StreamObserver<Void> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            connections.get(id).setDoOutput(request.getValue());
            responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(id).build());
            responseObserver.onCompleted();
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getDoInput(Void request, StreamObserver<Boolean> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.Boolean.newBuilder().setConId(id).setValue(connections.get(id).getDoInput()).build());
            responseObserver.onCompleted();
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Boolean.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void setDoInput(Boolean request, StreamObserver<Void> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            connections.get(id).setDoInput(request.getValue());
            responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(id).build());
            responseObserver.onCompleted();
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void toStringObject(Void request, StreamObserver<StringObject> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.StringObject.newBuilder().setConId(id).setValue(connections.get(id).toString()).build());
            responseObserver.onCompleted();
        } else {
            responseObserver.onNext(javafxbrowser.rpc.StringObject.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getHeaderFieldLong(FieldLong request, StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(id).setValue(connections.get(id).getHeaderFieldLong(request.getName(), request.getDefault())).build());
            responseObserver.onCompleted();
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getHeaderFieldInt(FieldInt request, StreamObserver<Int> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.Int.newBuilder().setConId(id).setValue(connections.get(id).getHeaderFieldInt(request.getName(), request.getDefault())).build());
            responseObserver.onCompleted();
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Int.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getLastModified(Void request, StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(id).setValue(connections.get(id).getLastModified()).build());
            responseObserver.onCompleted();
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getDate(Void request, StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(id).setValue(connections.get(id).getDate()).build());
            responseObserver.onCompleted();
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getExpiration(Void request, StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(id).setValue(connections.get(id).getExpiration()).build());
            responseObserver.onCompleted();
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getContentEncoding(Void request, StreamObserver<StringObject> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            String answer = connections.get(id).getContentEncoding();
            if (answer != null) {
                responseObserver.onNext(javafxbrowser.rpc.StringObject.newBuilder().setConId(id).setValue(answer).build());
            } else {
                responseObserver.onNext(javafxbrowser.rpc.StringObject.newBuilder().setConId(id).setValue("NulV").build());
            }
            responseObserver.onCompleted();
        } else {
            responseObserver.onNext(javafxbrowser.rpc.StringObject.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getContentType(Void request, StreamObserver<StringObject> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            String answer = connections.get(id).getContentType();
            if (answer != null) {
                responseObserver.onNext(javafxbrowser.rpc.StringObject.newBuilder().setConId(id).setValue(answer).build());
            } else {
                responseObserver.onNext(javafxbrowser.rpc.StringObject.newBuilder().setConId(id).setValue("NulV").build());
            }
            responseObserver.onCompleted();
        } else {
            responseObserver.onNext(javafxbrowser.rpc.StringObject.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getContentLengthLong(Void request, StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(id).setValue(connections.get(id).getContentLengthLong()).build());
            responseObserver.onCompleted();
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getContentLength(Void request, StreamObserver<javafxbrowser.rpc.Int> responseObserver) {
        Long id = request.getConId();
        if (connections.containsKey(id)) {
            responseObserver.onNext(javafxbrowser.rpc.Int.newBuilder().setConId(id).setValue(connections.get(id).getContentLength()).build());
            responseObserver.onCompleted();
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Int.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
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
                responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(-2).build());
                responseObserver.onCompleted();
            }
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getInputStream(Void request, StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
        long idCon = request.getConId();
        if (connections.containsKey(idCon)) {
            Long generatedId = (long) (Math.random() * Long.MAX_VALUE);
            while (inputStreams.containsKey(generatedId)) {
                generatedId = (long) (Math.random() * Long.MAX_VALUE);
            }
            try {
                inputStreams.put(generatedId, connections.get(idCon).getInputStream());
                responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(idCon).setValue(generatedId).build());
                responseObserver.onCompleted();
            } catch (IOException ex) {
                ex.printStackTrace();
                responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(-2).build());
                responseObserver.onCompleted();
            }
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    public void getOutputStream(Void request, StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
        long idCon = request.getConId();
        if (connections.containsKey(idCon)) {
            Long generatedId = (long) (Math.random() * Long.MAX_VALUE);
            while (outputStreams.containsKey(generatedId)) {
                generatedId = (long) (Math.random() * Long.MAX_VALUE);
            }
            try {
                outputStreams.put(generatedId, connections.get(idCon).getOutputStream());
                responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(idCon).setValue(generatedId).build());
                responseObserver.onCompleted();
            } catch (IOException ex) {
                ex.printStackTrace();
                responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(-2).build());
                responseObserver.onCompleted();
            }
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
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
    // InputStream Part
    @Override
    public void inputStreamMarkSupported(Void request, StreamObserver<Boolean> responseObserver) {
        Long id = request.getConId();
        if (inputStreams.containsKey(id)) {
            responseObserver.onNext(Boolean.newBuilder().setConId(id).setValue(inputStreams.get(id).markSupported()).build());
            responseObserver.onCompleted();

        } else {
            responseObserver.onNext(javafxbrowser.rpc.Boolean.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void inputStreamReset(Void request, StreamObserver<Void> responseObserver) {
        Long id = request.getConId();
        if (inputStreams.containsKey(id)) {
            try {
                inputStreams.get(id).reset();
                responseObserver.onNext(Void.newBuilder().setConId(id).build());
                responseObserver.onCompleted();
            } catch (IOException ex) {
                ex.printStackTrace();
                responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(-2).build());
                responseObserver.onCompleted();
            }
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }

    }

    @Override
    public void inputStreamMark(Int request, StreamObserver<Void> responseObserver) {
        Long id = request.getConId();
        if (inputStreams.containsKey(id)) {
            inputStreams.get(id).mark(request.getValue());
            responseObserver.onNext(Void.newBuilder().setConId(id).build());
            responseObserver.onCompleted();
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void inputStreamAvailable(Void request, StreamObserver<Int> responseObserver) {
        Long id = request.getConId();
        if (inputStreams.containsKey(id)) {
            try {
                responseObserver.onNext(Int.newBuilder().setConId(id).setValue(inputStreams.get(id).available()).build());
                responseObserver.onCompleted();
            } catch (IOException ex) {
                ex.printStackTrace();
                responseObserver.onNext(javafxbrowser.rpc.Int.newBuilder().setConId(-2).build());
                responseObserver.onCompleted();
            }
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Int.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void inputStreamSkip(javafxbrowser.rpc.Long request, StreamObserver<javafxbrowser.rpc.Long> responseObserver) {
        Long id = request.getConId();
        if (inputStreams.containsKey(id)) {
            try {
                responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(id).setValue(inputStreams.get(id).skip(request.getValue())).build());
                responseObserver.onCompleted();
            } catch (IOException ex) {
                ex.printStackTrace();
                responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(-2).build());
                responseObserver.onCompleted();
            }
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Long.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void inputStreamReadArrayOff(ByteArrayOffset request, StreamObserver<StreamRead> responseObserver) {
        Long id = request.getConId();
        if (inputStreams.containsKey(id)) {
            try {
                byte[] array = request.getArray().toByteArray();
                int answer = inputStreams.get(id).read(array, request.getOffset(), request.getLen());
                responseObserver.onNext(StreamRead.newBuilder().setArray(ByteString.copyFrom(array)).setAmount(answer).build());
                responseObserver.onCompleted();
            } catch (IOException ex) {
                ex.printStackTrace();
                responseObserver.onNext(javafxbrowser.rpc.StreamRead.newBuilder().setAmount(-2).build());
                responseObserver.onCompleted();
            }
        } else {
            responseObserver.onNext(javafxbrowser.rpc.StreamRead.newBuilder().setAmount(-3).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void inputStreamReadArray(ByteArray request, StreamObserver<StreamRead> responseObserver) {
        Long id = request.getConId();
        if (inputStreams.containsKey(id)) {
            try {
                byte[] array = request.getArray().toByteArray();
                int answer = inputStreams.get(id).read(array);
                responseObserver.onNext(StreamRead.newBuilder().setArray(ByteString.copyFrom(array)).setAmount(answer).build());
                responseObserver.onCompleted();
            } catch (IOException ex) {
                ex.printStackTrace();
                responseObserver.onNext(StreamRead.newBuilder().setAmount(-2).build());
                responseObserver.onCompleted();
            }
        } else {
            responseObserver.onNext(javafxbrowser.rpc.StreamRead.newBuilder().setAmount(-3).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void inputStreamRead(Void request, StreamObserver<Int> responseObserver) {
        Long id = request.getConId();
        if (inputStreams.containsKey(id)) {
            try {
                responseObserver.onNext(Int.newBuilder().setConId(id).setValue(inputStreams.get(id).read()).build());
                responseObserver.onCompleted();
            } catch (IOException ex) {
                ex.printStackTrace();
                responseObserver.onNext(Int.newBuilder().setConId(id).setValue(-2).build());
                responseObserver.onCompleted();
            }
        } else {
            responseObserver.onNext(Int.newBuilder().setConId(id).setValue(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void inputStreamClose(Void request, StreamObserver<Void> responseObserver) {
        Long id = request.getConId();
        if (inputStreams.containsKey(id)) {
            try {
                inputStreams.get(id).close();
                responseObserver.onNext(Void.newBuilder().setConId(id).build());
                responseObserver.onCompleted();
            } catch (IOException ex) {
                ex.printStackTrace();
                responseObserver.onNext(Void.newBuilder().setConId(-2).build());
                responseObserver.onCompleted();
            }

            inputStreams.remove(id);
        } else {
            responseObserver.onNext(Void.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    //OutputStreamPart
    @Override
    public void outputStreamWriteArray(ByteArray request, StreamObserver<Void> responseObserver) {
        Long id = request.getConId();
        if (outputStreams.containsKey(id)) {
            try {
                outputStreams.get(id).write(request.getArray().toByteArray());
                responseObserver.onNext(Void.newBuilder().setConId(id).build());
                responseObserver.onCompleted();
            } catch (IOException ex) {
                responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(-2).build());
                responseObserver.onCompleted();
            }
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void outputStreamWriteArrayOff(ByteArrayOffset request, StreamObserver<Void> responseObserver) {
        Long id = request.getConId();
        if (outputStreams.containsKey(id)) {
            try {
                outputStreams.get(id).write(request.getArray().toByteArray(),request.getOffset(),request.getLen());
                responseObserver.onNext(Void.newBuilder().setConId(id).build());
                responseObserver.onCompleted();
            } catch (IOException ex) {
                responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(-2).build());
                responseObserver.onCompleted();
            }
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }

    }

    @Override
    public void outputStreamFlush(Void request, StreamObserver<Void> responseObserver) {
        Long id = request.getConId();
        if (outputStreams.containsKey(id)) {
            try {
                outputStreams.get(id).flush();
                responseObserver.onNext(Void.newBuilder().setConId(id).build());
                responseObserver.onCompleted();
            } catch (IOException ex) {
                responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(-2).build());
                responseObserver.onCompleted();
            }
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void outputStreamWrite(Int request, StreamObserver<Void> responseObserver) {
        Long id = request.getConId();
        if (outputStreams.containsKey(id)) {
            try {
                outputStreams.get(id).write(request.getValue());
                responseObserver.onNext(Void.newBuilder().setConId(id).build());
                responseObserver.onCompleted();
            } catch (IOException ex) {
                responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(-2).build());
                responseObserver.onCompleted();
            }
        } else {
            responseObserver.onNext(javafxbrowser.rpc.Void.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void outputStreamClose(Void request, StreamObserver<Void> responseObserver) {
        Long id = request.getConId();
        if (outputStreams.containsKey(id)) {
            try {
                outputStreams.get(id).close();
                responseObserver.onNext(Void.newBuilder().setConId(id).build());
                responseObserver.onCompleted();
            } catch (IOException ex) {
                ex.printStackTrace();
                responseObserver.onNext(Void.newBuilder().setConId(-2).build());
                responseObserver.onCompleted();
            }

            outputStreams.remove(id);
        } else {
            responseObserver.onNext(Void.newBuilder().setConId(-1).build());
            responseObserver.onCompleted();
        }
    }

}
