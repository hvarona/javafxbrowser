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
// Generated from file `rpc.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package javafxbrowser.rpc;

public abstract class Callback_InterComm_getConfig
    extends IceInternal.TwowayCallback implements Ice.TwowayCallbackArg1<javafxbrowser.cfg.BrowserConfigurator>
{
    public final void __completed(Ice.AsyncResult __result)
    {
        InterCommPrxHelper.__getConfig_completed(this, __result);
    }
}
