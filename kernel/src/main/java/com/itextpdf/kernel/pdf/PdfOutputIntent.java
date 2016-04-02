package com.itextpdf.kernel.pdf;

import com.itextpdf.kernel.pdf.colorspace.PdfCieBasedCs;

import java.io.InputStream;

public class PdfOutputIntent extends PdfObjectWrapper<PdfDictionary> {

    private static final long serialVersionUID = -3814334679568337730L;

	/**
     * Creates output intent dictionary. Null values are allowed to
     * suppress any key.
     * By default output intent subtype is GTS_PDFA1, use setter to change it.
     */
    public PdfOutputIntent(String outputConditionIdentifier, String outputCondition, String registryName, String info, InputStream iccStream) {
        super(new PdfDictionary());
        setOutputIntentSubtype(PdfName.GTS_PDFA1);
        getPdfObject().put(PdfName.Type, PdfName.OutputIntent);
        if (outputCondition != null)
            setOutputCondition(outputCondition);
        if (outputConditionIdentifier != null)
            setOutputConditionIdentifier(outputConditionIdentifier);
        if (registryName != null)
            setRegistryName(registryName);
        if (info != null)
            setInfo(info);
        if (iccStream != null) {
            setDestOutputProfile(iccStream);
        }
    }

    public PdfOutputIntent(PdfDictionary outputIntentDict) {
        super(outputIntentDict);
    }

    public PdfStream getDestOutputProfile() {
        return getPdfObject().getAsStream(PdfName.DestOutputProfile);
    }

    public void setDestOutputProfile(InputStream iccStream) {
        PdfStream stream = PdfCieBasedCs.IccBased.getIccProfileStream(iccStream);
        getPdfObject().put(PdfName.DestOutputProfile, stream);
    }

    public PdfString getInfo() {
        return getPdfObject().getAsString(PdfName.Info);
    }

    public void setInfo(String info) {
        getPdfObject().put(PdfName.Info, new PdfString(info));
    }

    public PdfString getRegistryName() {
        return getPdfObject().getAsString(PdfName.RegistryName);
    }

    public void setRegistryName(String registryName) {
        getPdfObject().put(PdfName.RegistryName, new PdfString(registryName));
    }

    public PdfString getOutputConditionIdentifier() {
        return getPdfObject().getAsString(PdfName.OutputConditionIdentifier);
    }

    public void setOutputConditionIdentifier(String outputConditionIdentifier) {
        getPdfObject().put(PdfName.OutputConditionIdentifier, new PdfString(outputConditionIdentifier));
    }

    public PdfString getOutputCondition() {
        return getPdfObject().getAsString(PdfName.OutputCondition);
    }

    public void setOutputCondition(String outputCondition) {
        getPdfObject().put(PdfName.OutputCondition, new PdfString(outputCondition));
    }

    public PdfName getOutputIntentSubtype() {
        return getPdfObject().getAsName(PdfName.S);
    }

    public void setOutputIntentSubtype(PdfName subtype) {
        getPdfObject().put(PdfName.S, subtype);
    }

    @Override
    protected boolean isWrappedObjectMustBeIndirect() {
        return false;
    }

}
