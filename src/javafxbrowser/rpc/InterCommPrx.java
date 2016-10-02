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

public interface InterCommPrx extends Ice.ObjectPrx
{
    public void printString(String s);

    public void printString(String s, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_printString(String s);

    public Ice.AsyncResult begin_printString(String s, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_printString(String s, Ice.Callback __cb);

    public Ice.AsyncResult begin_printString(String s, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_printString(String s, Callback_InterComm_printString __cb);

    public Ice.AsyncResult begin_printString(String s, java.util.Map<String, String> __ctx, Callback_InterComm_printString __cb);

    public Ice.AsyncResult begin_printString(String s, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_printString(String s, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                             IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_printString(String s, 
                                             java.util.Map<String, String> __ctx, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_printString(String s, 
                                             java.util.Map<String, String> __ctx, 
                                             IceInternal.Functional_VoidCallback __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                             IceInternal.Functional_BoolCallback __sentCb);

    public void end_printString(Ice.AsyncResult __result);

    public config getConfig();

    public config getConfig(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getConfig();

    public Ice.AsyncResult begin_getConfig(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getConfig(Ice.Callback __cb);

    public Ice.AsyncResult begin_getConfig(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_getConfig(Callback_InterComm_getConfig __cb);

    public Ice.AsyncResult begin_getConfig(java.util.Map<String, String> __ctx, Callback_InterComm_getConfig __cb);

    public Ice.AsyncResult begin_getConfig(IceInternal.Functional_GenericCallback1<config> __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_getConfig(IceInternal.Functional_GenericCallback1<config> __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                           IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_getConfig(java.util.Map<String, String> __ctx, 
                                           IceInternal.Functional_GenericCallback1<config> __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_getConfig(java.util.Map<String, String> __ctx, 
                                           IceInternal.Functional_GenericCallback1<config> __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                           IceInternal.Functional_BoolCallback __sentCb);

    public config end_getConfig(Ice.AsyncResult __result);

    public void setConfig(config conf);

    public void setConfig(config conf, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_setConfig(config conf);

    public Ice.AsyncResult begin_setConfig(config conf, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_setConfig(config conf, Ice.Callback __cb);

    public Ice.AsyncResult begin_setConfig(config conf, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_setConfig(config conf, Callback_InterComm_setConfig __cb);

    public Ice.AsyncResult begin_setConfig(config conf, java.util.Map<String, String> __ctx, Callback_InterComm_setConfig __cb);

    public Ice.AsyncResult begin_setConfig(config conf, 
                                           IceInternal.Functional_VoidCallback __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_setConfig(config conf, 
                                           IceInternal.Functional_VoidCallback __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                           IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_setConfig(config conf, 
                                           java.util.Map<String, String> __ctx, 
                                           IceInternal.Functional_VoidCallback __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_setConfig(config conf, 
                                           java.util.Map<String, String> __ctx, 
                                           IceInternal.Functional_VoidCallback __responseCb, 
                                           IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                           IceInternal.Functional_BoolCallback __sentCb);

    public void end_setConfig(Ice.AsyncResult __result);
}
