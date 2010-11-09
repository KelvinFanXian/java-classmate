package com.fasterxml.classmate.types;

import java.util.*;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.TypeBindings;
import com.fasterxml.classmate.members.RawConstructor;
import com.fasterxml.classmate.members.RawField;
import com.fasterxml.classmate.members.RawMethod;

public final class ResolvedArrayType  extends ResolvedType
{
    protected final ResolvedType _elementType;
    
    /*
    /**********************************************************************
    /* Life cycle
    /**********************************************************************
     */

    public ResolvedArrayType(Class<?> erased, TypeBindings bindings,
            ResolvedObjectType superclass, // must be java.lang.Object
            ResolvedType elementType)
    {
        super(erased, bindings);
        _elementType = elementType;
    }
    
    @Override
    public boolean canCreateSubtypes() {
        return false;
    }
    
    /*
    /**********************************************************************
    /* Accessors for related types
    /**********************************************************************
     */
    
    @Override
    public ResolvedType getParentClass() { return null; }
    
    @Override
    public ResolvedType getSelfReferencedType() { return null; }
    
    @Override
    public List<ResolvedType> getImplementedInterfaces() {
        return Collections.emptyList();
    }
    
    /*
    /**********************************************************************
    /* Simple property accessors
    /**********************************************************************
     */

    @Override
    public boolean isInterface() {
        return false;
    }

    @Override
    public boolean isAbstract() { return false; }

    @Override
    public ResolvedType getArrayElementType() { return _elementType; }

    @Override
    public boolean isArray() { return true; }

    @Override
    public boolean isPrimitive() { return false; }

    /*
    /**********************************************************************
    /* Accessors for raw (minimally procesed) members
    /**********************************************************************
     */
    
    public List<RawField> getMemberFields() { return Collections.emptyList(); }
    public List<RawField> getStaticFields() { return Collections.emptyList(); }
    public List<RawMethod> getMemberMethods() { return Collections.emptyList(); }
    public List<RawMethod> getStaticMethods() { return Collections.emptyList(); }
    public List<RawConstructor> getConstructors() { return Collections.emptyList(); }    

    /*
    /**********************************************************************
    /* String representations
    /**********************************************************************
     */

    @Override
    public StringBuilder appendSignature(StringBuilder sb) {
        sb.append('[');
        return _elementType.appendSignature(sb);
    }

    @Override
    public StringBuilder appendErasedSignature(StringBuilder sb) {
        sb.append('[');
        return _elementType.appendErasedSignature(sb);
    }

    public StringBuilder appendBriefDescription(StringBuilder sb)
    {
        sb = _elementType.appendBriefDescription(sb);
        sb.append("[]");
        return sb;
    }

    public StringBuilder appendFullDescription(StringBuilder sb) {
        return appendBriefDescription(sb);
    }
}
