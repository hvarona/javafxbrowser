// **********************************************************************
//
// Copyright (c) 2003-2016 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.6.2
//
// <auto-generated>
//
// Generated from file `Printer.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package javafxbrowser.rpc;

/**
 * Provides type-specific helper functions.
 **/
public final class InterCommPrxHelper extends Ice.ObjectPrxHelperBase implements InterCommPrx
{
    private static final String __getConfig_name = "getConfig";

    public config getConfig()
    {
        return getConfig(null, false);
    }

    public config getConfig(java.util.Map<String, String> __ctx)
    {
        return getConfig(__ctx, true);
    }

    private config getConfig(java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        __checkTwowayOnly(__getConfig_name);
        return end_getConfig(begin_getConfig(__ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_getConfig()
    {
        return begin_getConfig(null, false, false, null);
    }

    public Ice.AsyncResult begin_getConfig(java.util.Map<String, String> __ctx)
    {
        return begin_getConfig(__ctx, true, false, null);
    }

    public Ice.AsyncResult begin_getConfig(Ice.Callback __cb)
    {
        return begin_getConfig(null, false, false, __cb);
    }

    public Ice.AsyncResult begin_getConfig(java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_getConfig(__ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_getConfig(Callback_InterComm_getConfig __cb)
    {
        return begin_getConfig(null, false, false, __cb);
    }

    public Ice.AsyncResult begin_getConfig(java.util.Map<String, String> __ctx, Callback_InterComm_getConfig __cb)
    {
        return begin_getConfig(__ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_getConfig(IceInternal.Functional_GenericCallback1<config> __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_getConfig(null, false, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_getConfig(IceInternal.Functional_GenericCallback1<config> __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                           IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_getConfig(null, false, false, __responseCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_getConfig(java.util.Map<String, String> __ctx, 
                                           IceInternal.Functional_GenericCallback1<config> __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_getConfig(__ctx, true, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_getConfig(java.util.Map<String, String> __ctx, 
                                           IceInternal.Functional_GenericCallback1<config> __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                           IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_getConfig(__ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_getConfig(java.util.Map<String, String> __ctx, 
                                            boolean __explicitCtx, 
                                            boolean __synchronous, 
                                            IceInternal.Functional_GenericCallback1<config> __responseCb, 
                                            IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                            IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_getConfig(__ctx, __explicitCtx, __synchronous, 
                               new IceInternal.Functional_TwowayCallbackArg1<javafxbrowser.rpc.config>(__responseCb, __exceptionCb, __sentCb)
                                   {
                                       public final void __completed(Ice.AsyncResult __result)
                                       {
                                           InterCommPrxHelper.__getConfig_completed(this, __result);
                                       }
                                   });
    }

    private Ice.AsyncResult begin_getConfig(java.util.Map<String, String> __ctx, 
                                            boolean __explicitCtx, 
                                            boolean __synchronous, 
                                            IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__getConfig_name);
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__getConfig_name, __cb);
        try
        {
            __result.prepare(__getConfig_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            __result.writeEmptyParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public config end_getConfig(Ice.AsyncResult __iresult)
    {
        IceInternal.OutgoingAsync __result = IceInternal.OutgoingAsync.check(__iresult, this, __getConfig_name);
        try
        {
            if(!__result.__wait())
            {
                try
                {
                    __result.throwUserException();
                }
                catch(Ice.UserException __ex)
                {
                    throw new Ice.UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            IceInternal.BasicStream __is = __result.startReadParams();
            configHolder __ret = new configHolder();
            __is.readObject(__ret);
            __is.readPendingObjects();
            __result.endReadParams();
            return __ret.value;
        }
        finally
        {
            if(__result != null)
            {
                __result.cacheMessageBuffers();
            }
        }
    }

    static public void __getConfig_completed(Ice.TwowayCallbackArg1<config> __cb, Ice.AsyncResult __result)
    {
        javafxbrowser.rpc.InterCommPrx __proxy = (javafxbrowser.rpc.InterCommPrx)__result.getProxy();
        config __ret = null;
        try
        {
            __ret = __proxy.end_getConfig(__result);
        }
        catch(Ice.LocalException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        catch(Ice.SystemException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }

    private static final String __printString_name = "printString";

    public void printString(String s)
    {
        printString(s, null, false);
    }

    public void printString(String s, java.util.Map<String, String> __ctx)
    {
        printString(s, __ctx, true);
    }

    private void printString(String s, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        end_printString(begin_printString(s, __ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_printString(String s)
    {
        return begin_printString(s, null, false, false, null);
    }

    public Ice.AsyncResult begin_printString(String s, java.util.Map<String, String> __ctx)
    {
        return begin_printString(s, __ctx, true, false, null);
    }

    public Ice.AsyncResult begin_printString(String s, Ice.Callback __cb)
    {
        return begin_printString(s, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_printString(String s, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_printString(s, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_printString(String s, Callback_InterComm_printString __cb)
    {
        return begin_printString(s, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_printString(String s, java.util.Map<String, String> __ctx, Callback_InterComm_printString __cb)
    {
        return begin_printString(s, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_printString(String s, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_printString(s, null, false, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_printString(String s, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                             IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_printString(s, null, false, false, __responseCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_printString(String s, 
                                             java.util.Map<String, String> __ctx, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_printString(s, __ctx, true, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_printString(String s, 
                                             java.util.Map<String, String> __ctx, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                             IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_printString(s, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_printString(String s, 
                                              java.util.Map<String, String> __ctx, 
                                              boolean __explicitCtx, 
                                              boolean __synchronous, 
                                              IceInternal.Functional_VoidCallback __responseCb, 
                                              IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                              IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_printString(s, 
                                 __ctx, 
                                 __explicitCtx, 
                                 __synchronous, 
                                 new IceInternal.Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }

    private Ice.AsyncResult begin_printString(String s, 
                                              java.util.Map<String, String> __ctx, 
                                              boolean __explicitCtx, 
                                              boolean __synchronous, 
                                              IceInternal.CallbackBase __cb)
    {
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__printString_name, __cb);
        try
        {
            __result.prepare(__printString_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            IceInternal.BasicStream __os = __result.startWriteParams(Ice.FormatType.DefaultFormat);
            __os.writeString(s);
            __result.endWriteParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public void end_printString(Ice.AsyncResult __iresult)
    {
        __end(__iresult, __printString_name);
    }

    private static final String __setConfig_name = "setConfig";

    public void setConfig(config conf)
    {
        setConfig(conf, null, false);
    }

    public void setConfig(config conf, java.util.Map<String, String> __ctx)
    {
        setConfig(conf, __ctx, true);
    }

    private void setConfig(config conf, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        end_setConfig(begin_setConfig(conf, __ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_setConfig(config conf)
    {
        return begin_setConfig(conf, null, false, false, null);
    }

    public Ice.AsyncResult begin_setConfig(config conf, java.util.Map<String, String> __ctx)
    {
        return begin_setConfig(conf, __ctx, true, false, null);
    }

    public Ice.AsyncResult begin_setConfig(config conf, Ice.Callback __cb)
    {
        return begin_setConfig(conf, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_setConfig(config conf, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_setConfig(conf, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_setConfig(config conf, Callback_InterComm_setConfig __cb)
    {
        return begin_setConfig(conf, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_setConfig(config conf, java.util.Map<String, String> __ctx, Callback_InterComm_setConfig __cb)
    {
        return begin_setConfig(conf, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_setConfig(config conf, 
                                           IceInternal.Functional_VoidCallback __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_setConfig(conf, null, false, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_setConfig(config conf, 
                                           IceInternal.Functional_VoidCallback __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                           IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_setConfig(conf, null, false, false, __responseCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_setConfig(config conf, 
                                           java.util.Map<String, String> __ctx, 
                                           IceInternal.Functional_VoidCallback __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_setConfig(conf, __ctx, true, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_setConfig(config conf, 
                                           java.util.Map<String, String> __ctx, 
                                           IceInternal.Functional_VoidCallback __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                           IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_setConfig(conf, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_setConfig(config conf, 
                                            java.util.Map<String, String> __ctx, 
                                            boolean __explicitCtx, 
                                            boolean __synchronous, 
                                            IceInternal.Functional_VoidCallback __responseCb, 
                                            IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                            IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_setConfig(conf, 
                               __ctx, 
                               __explicitCtx, 
                               __synchronous, 
                               new IceInternal.Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }

    private Ice.AsyncResult begin_setConfig(config conf, 
                                            java.util.Map<String, String> __ctx, 
                                            boolean __explicitCtx, 
                                            boolean __synchronous, 
                                            IceInternal.CallbackBase __cb)
    {
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__setConfig_name, __cb);
        try
        {
            __result.prepare(__setConfig_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            IceInternal.BasicStream __os = __result.startWriteParams(Ice.FormatType.DefaultFormat);
            __os.writeObject(conf);
            __os.writePendingObjects();
            __result.endWriteParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public void end_setConfig(Ice.AsyncResult __iresult)
    {
        __end(__iresult, __setConfig_name);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static InterCommPrx checkedCast(Ice.ObjectPrx __obj)
    {
        return checkedCastImpl(__obj, ice_staticId(), InterCommPrx.class, InterCommPrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __ctx The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static InterCommPrx checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __ctx, ice_staticId(), InterCommPrx.class, InterCommPrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static InterCommPrx checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return checkedCastImpl(__obj, __facet, ice_staticId(), InterCommPrx.class, InterCommPrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @param __ctx The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static InterCommPrx checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), InterCommPrx.class, InterCommPrxHelper.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param __obj The untyped proxy.
     * @return A proxy for this type.
     **/
    public static InterCommPrx uncheckedCast(Ice.ObjectPrx __obj)
    {
        return uncheckedCastImpl(__obj, InterCommPrx.class, InterCommPrxHelper.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    public static InterCommPrx uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return uncheckedCastImpl(__obj, __facet, InterCommPrx.class, InterCommPrxHelper.class);
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::javafxbrowser::rpc::InterComm"
    };

    /**
     * Provides the Slice type ID of this type.
     * @return The Slice type ID.
     **/
    public static String ice_staticId()
    {
        return __ids[1];
    }

    public static void __write(IceInternal.BasicStream __os, InterCommPrx v)
    {
        __os.writeProxy(v);
    }

    public static InterCommPrx __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            InterCommPrxHelper result = new InterCommPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }

    public static final long serialVersionUID = 0L;
}