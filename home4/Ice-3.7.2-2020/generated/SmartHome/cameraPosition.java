//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.3
//
// <auto-generated>
//
// Generated from file `smart-home.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package SmartHome;

public class cameraPosition implements java.lang.Cloneable,
                                       java.io.Serializable
{
    public int verticalPosition;

    public int horizontalPosition;

    public cameraPosition()
    {
    }

    public cameraPosition(int verticalPosition, int horizontalPosition)
    {
        this.verticalPosition = verticalPosition;
        this.horizontalPosition = horizontalPosition;
    }

    public boolean equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        cameraPosition r = null;
        if(rhs instanceof cameraPosition)
        {
            r = (cameraPosition)rhs;
        }

        if(r != null)
        {
            if(this.verticalPosition != r.verticalPosition)
            {
                return false;
            }
            if(this.horizontalPosition != r.horizontalPosition)
            {
                return false;
            }

            return true;
        }

        return false;
    }

    public int hashCode()
    {
        int h_ = 5381;
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::SmartHome::cameraPosition");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, verticalPosition);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, horizontalPosition);
        return h_;
    }

    public cameraPosition clone()
    {
        cameraPosition c = null;
        try
        {
            c = (cameraPosition)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        ostr.writeInt(this.verticalPosition);
        ostr.writeInt(this.horizontalPosition);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.verticalPosition = istr.readInt();
        this.horizontalPosition = istr.readInt();
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, cameraPosition v)
    {
        if(v == null)
        {
            _nullMarshalValue.ice_writeMembers(ostr);
        }
        else
        {
            v.ice_writeMembers(ostr);
        }
    }

    static public cameraPosition ice_read(com.zeroc.Ice.InputStream istr)
    {
        cameraPosition v = new cameraPosition();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<cameraPosition> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, cameraPosition v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.VSize))
        {
            ostr.writeSize(8);
            ice_write(ostr, v);
        }
    }

    static public java.util.Optional<cameraPosition> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.VSize))
        {
            istr.skipSize();
            return java.util.Optional.of(cameraPosition.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final cameraPosition _nullMarshalValue = new cameraPosition();

    /** @hidden */
    public static final long serialVersionUID = -1583842351L;
}
