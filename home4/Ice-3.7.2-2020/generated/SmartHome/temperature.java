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

public class temperature implements java.lang.Cloneable,
                                    java.io.Serializable
{
    public float value;

    public unit unit;

    public temperature()
    {
        this.unit = unit.CELCIUS;
    }

    public temperature(float value, unit unit)
    {
        this.value = value;
        this.unit = unit;
    }

    public boolean equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        temperature r = null;
        if(rhs instanceof temperature)
        {
            r = (temperature)rhs;
        }

        if(r != null)
        {
            if(this.value != r.value)
            {
                return false;
            }
            if(this.unit != r.unit)
            {
                if(this.unit == null || r.unit == null || !this.unit.equals(r.unit))
                {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public int hashCode()
    {
        int h_ = 5381;
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::SmartHome::temperature");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, value);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, unit);
        return h_;
    }

    public temperature clone()
    {
        temperature c = null;
        try
        {
            c = (temperature)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        ostr.writeFloat(this.value);
        unit.ice_write(ostr, this.unit);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.value = istr.readFloat();
        this.unit = unit.ice_read(istr);
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, temperature v)
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

    static public temperature ice_read(com.zeroc.Ice.InputStream istr)
    {
        temperature v = new temperature();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<temperature> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, temperature v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            int pos = ostr.startSize();
            ice_write(ostr, v);
            ostr.endSize(pos);
        }
    }

    static public java.util.Optional<temperature> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            istr.skip(4);
            return java.util.Optional.of(temperature.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final temperature _nullMarshalValue = new temperature();

    /** @hidden */
    public static final long serialVersionUID = -1156239716L;
}
