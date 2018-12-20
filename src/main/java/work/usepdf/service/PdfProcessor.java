package work.usepdf.service;

import work.usepdf.object.Unit;

import java.io.ByteArrayOutputStream;
import java.util.List;

public interface PdfProcessor {

    ByteArrayOutputStream getPdfForEmail(List<Unit> unitList);
}
