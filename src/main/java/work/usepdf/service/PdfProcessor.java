package work.usepdf.service;

import work.usepdf.model.Unit;

import java.io.ByteArrayOutputStream;
import java.util.List;

public interface PdfProcessor {

    ByteArrayOutputStream getPdfForEmail(List<Unit> unitList);
}
