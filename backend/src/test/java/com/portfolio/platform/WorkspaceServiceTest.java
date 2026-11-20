package com.portfolio.platform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class WorkspaceServiceTest {
  @Test void createsAndSearchesItems() {
    var service = new WorkspaceService();
    var created = service.create(new WorkspaceItem(null, "Transition fund disclosure", "Fund Office", "Draft", "High"));
    assertEquals("Transition fund disclosure", created.title());
    assertEquals(1, service.find("Transition fund disclosure").size());
  }

  @Test void updatesKnownItemsAndRejectsMissingOnes() {
    var service = new WorkspaceService();
    var updated = service.update(1, new WorkspaceItem(null, "Updated", "Owner", "Approved", "Low"));
    assertEquals("Approved", updated.status());
    assertThrows(ItemNotFoundException.class, () -> service.update(999, updated));
  }
}
