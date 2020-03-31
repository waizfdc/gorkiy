package org.koin.core.error;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lorg/koin/core/error/DefinitionParameterException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "str", "", "(Ljava/lang/String;)V", "koin-core"}, k = 1, mv = {1, 1, 16})
/* compiled from: DefinitionParameterException.kt */
public final class DefinitionParameterException extends Exception {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefinitionParameterException(String str) {
        super(str);
        Intrinsics.checkParameterIsNotNull(str, "str");
    }
}
