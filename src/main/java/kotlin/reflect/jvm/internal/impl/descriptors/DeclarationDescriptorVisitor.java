package kotlin.reflect.jvm.internal.impl.descriptors;

public interface DeclarationDescriptorVisitor<R, D> {
    R visitClassDescriptor(ClassDescriptor classDescriptor, D d);

    R visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, Object obj);

    R visitFunctionDescriptor(FunctionDescriptor functionDescriptor, Object obj);

    R visitModuleDeclaration(ModuleDescriptor moduleDescriptor, D d);

    R visitPackageFragmentDescriptor(PackageFragmentDescriptor packageFragmentDescriptor, D d);

    R visitPackageViewDescriptor(PackageViewDescriptor packageViewDescriptor, D d);

    R visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, Object obj);

    R visitPropertyGetterDescriptor(PropertyGetterDescriptor propertyGetterDescriptor, D d);

    R visitPropertySetterDescriptor(PropertySetterDescriptor propertySetterDescriptor, D d);

    R visitReceiverParameterDescriptor(ReceiverParameterDescriptor receiverParameterDescriptor, D d);

    R visitTypeAliasDescriptor(TypeAliasDescriptor typeAliasDescriptor, D d);

    R visitTypeParameterDescriptor(TypeParameterDescriptor typeParameterDescriptor, D d);

    R visitValueParameterDescriptor(ValueParameterDescriptor valueParameterDescriptor, D d);
}
